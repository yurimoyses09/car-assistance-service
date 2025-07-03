package com.moyses.api_system_car.application.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.moyses.api_system_car.domain.repository.ICarRepository;
import com.moyses.api_system_car.domain.repository.IServiceOrderRepository;
import com.moyses.api_system_car.domain.repository.IUserRepository;
import com.moyses.api_system_car.infraestructure.persistence.entity.ServiceOrderEntity;
import com.moyses.api_system_car.infraestructure.persistence.mapper.ServiceOrderMapper;
import com.moyses.api_system_car.infraestructure.web.dto.serviceOrder.ServiceOrderRequest;
import com.moyses.api_system_car.infraestructure.web.dto.serviceOrder.ServiceOrderResponse;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ServiceOrderService {

    private final IServiceOrderRepository _repository;
    private final IUserRepository _userRepository;
    private final ICarRepository _carRepository;
    private final ServiceOrderMapper _mapper;

    public ServiceOrderService(IServiceOrderRepository repository, IUserRepository userRepository, ICarRepository carRepository, ServiceOrderMapper mapper) {
        _repository = repository;
        _userRepository = userRepository;
        _carRepository = carRepository;
        _mapper = mapper;
    }

    public ServiceOrderEntity createOrder(ServiceOrderRequest request){
        var user = _userRepository.findByEmail("");
        //var car  = _carRepository.getCarsByUser(user.get());

        var entity = _mapper.toEntity(request);

        entity.setId(UUID.randomUUID());
        //entity.setCar(car);
        //entity.setUser(user.get());

        return  _repository.createOrder(entity);
    }

    public List<ServiceOrderResponse> getListServices() throws IOException {
        var resource = new ClassPathResource("catalog/db.json");
        ObjectMapper mapper = new ObjectMapper();

        mapper.registerModule(new com.fasterxml.jackson.datatype.jsr310.JavaTimeModule());

        var node = mapper.readTree(resource.getInputStream());

        return mapper.convertValue(
                node.get("services"),
                new TypeReference<List<ServiceOrderResponse>>() {}
        );
    }

    public Optional<ServiceOrderResponse> getServiceById(Integer id) throws IOException {
        return getListServices().stream().filter(x -> x.getId().equals(id)).findFirst();
    }
}
