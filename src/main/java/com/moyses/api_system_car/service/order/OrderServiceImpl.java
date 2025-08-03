package com.moyses.api_system_car.service.order;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.moyses.api_system_car.domain.exception.CatalogLoadException;
import com.moyses.api_system_car.domain.model.ServiceAutomotiveOrder;
import com.moyses.api_system_car.domain.repository.ICarRepository;
import com.moyses.api_system_car.domain.repository.IServiceAutomotiveRepository;
import com.moyses.api_system_car.domain.repository.IUserRepository;
import com.moyses.api_system_car.domain.service.order.IOrderAutomotiveService;
import com.moyses.api_system_car.infraestructure.messaging.OrderMessagePublisher;
import com.moyses.api_system_car.infraestructure.persistence.mapper.ServiceAutomotiveOrderMapper;
import com.moyses.api_system_car.application.dto.serviceOrder.ServiceAutomotiveAvailableResponse;
import com.moyses.api_system_car.application.dto.serviceOrder.ServiceAutomotiveCreateOrder;
import com.moyses.api_system_car.application.dto.serviceOrder.ServiceAutomotiveOrderEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderServiceImpl implements IOrderAutomotiveService {

    private final IServiceAutomotiveRepository _repository;
    private final IUserRepository _userRepository;
    private final ICarRepository _carRepository;
    private final ServiceAutomotiveOrderMapper _orderMapper;

    @Autowired
    private final OrderMessagePublisher _publisher;

    public OrderServiceImpl(IServiceAutomotiveRepository repository, IUserRepository userRepository, ICarRepository carRepository, ServiceAutomotiveOrderMapper orderMapper, OrderMessagePublisher publisher) {
        _repository = repository;
        _userRepository = userRepository;
        _carRepository = carRepository;
        _orderMapper = orderMapper;
        _publisher = publisher;
    }

    @Override
    public ServiceAutomotiveOrder createOrder(ServiceAutomotiveCreateOrder request) {
        var user = _userRepository.findById(request.getId_user())
                .orElseThrow(() -> new UsernameNotFoundException("User Not found"));

        var car  = _carRepository.getCarByIdUser(user.getId());
        car.setUser(user);

        var service = getServiceById(request.getId_service())
                .orElseThrow(() -> new IllegalArgumentException("Service Not found"));

        var orderRequest = _orderMapper.toModel(car, user, request, service);

        return _repository.createOrder(orderRequest);
    }

    @Override
    public List<ServiceAutomotiveAvailableResponse> getListServices() {
        try (InputStream input = new ClassPathResource("catalog/db.json").getInputStream()) {
            ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

            JsonNode root = mapper.readTree(input);
            JsonNode serviceNode = root.path("services");

            return mapper.convertValue(serviceNode, new TypeReference<>() {});
        } catch (Exception e) {
            throw new CatalogLoadException("Error loading automotive service catalog", e);
        }
    }

    @Override
    public Optional<ServiceAutomotiveAvailableResponse> getServiceById(UUID id) {
        return getListServices().stream().filter(x -> x.getId().equals(id)).findFirst();
    }

    @Override
    public Optional<Boolean> isDateAvailable(LocalDateTime dateTime, UUID id) {
        return getServiceById(id)
                .map(service -> service.getAvailable_data().contains(dateTime));
    }

    @Override
    public void publishEvent(ServiceAutomotiveOrderEvent order) {
        _publisher.publish(order);
    }
}
