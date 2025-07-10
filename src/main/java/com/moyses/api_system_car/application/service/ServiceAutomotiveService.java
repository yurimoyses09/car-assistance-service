package com.moyses.api_system_car.application.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.moyses.api_system_car.application.service.port.in.IServiceAutomotiveService;
import com.moyses.api_system_car.domain.model.ServiceAutomotiveOrder;
import com.moyses.api_system_car.domain.repository.ICarRepository;
import com.moyses.api_system_car.domain.repository.IServiceAutomotiveRepository;
import com.moyses.api_system_car.domain.repository.IUserRepository;
import com.moyses.api_system_car.infraestructure.persistence.mapper.ServiceAutomotiveOrderMapper;
import com.moyses.api_system_car.infraestructure.web.dto.serviceOrder.ServiceAutomotiveOrderRequest;
import com.moyses.api_system_car.infraestructure.web.dto.serviceOrder.ServiceAutomotiveOrderResponse;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ServiceAutomotiveService implements IServiceAutomotiveService {

    private final IServiceAutomotiveRepository _repository;
    private final IUserRepository _userRepository;
    private final ICarRepository _carRepository;
    private final ServiceAutomotiveOrderMapper _mapper;

    public ServiceAutomotiveService(IServiceAutomotiveRepository repository, IUserRepository userRepository, ICarRepository carRepository, ServiceAutomotiveOrderMapper mapper) {
        _repository = repository;
        _userRepository = userRepository;
        _carRepository = carRepository;
        _mapper = mapper;
    }

    public ServiceAutomotiveOrder createOrder(ServiceAutomotiveOrderRequest request, UserDetails userDetails) throws IOException {
        var user = _userRepository.findByEmail(userDetails.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User Not found"));

        var car  = _carRepository.getCarByIdUser(user.getId());
        car.setUser(user);

        var service = getServiceById(request.getId_service())
                .orElseThrow(() -> new IllegalArgumentException("Service Not found"));

        var order = _mapper.toModel(car, user, request, service);

        return _repository.createOrder(order);
    }

    public List<ServiceAutomotiveOrderResponse> getListServices() throws IOException {
        ObjectMapper mapper = new ObjectMapper()
                .registerModule(new JavaTimeModule());

        try (InputStream input = new ClassPathResource("catalog/db.json").getInputStream()){
            JsonNode root = mapper.readTree(input);
            JsonNode serviceNode = root.path("services");

            return mapper.convertValue(serviceNode, new TypeReference<List<ServiceAutomotiveOrderResponse>>() {});
        }
    }

    public Optional<ServiceAutomotiveOrderResponse> getServiceById(UUID id) throws IOException {
        return getListServices().stream().filter(x -> x.getId().equals(id)).findFirst();
    }
}
