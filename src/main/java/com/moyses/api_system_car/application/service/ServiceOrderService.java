package com.moyses.api_system_car.application.service;

import com.moyses.api_system_car.domain.repository.CarRepository;
import com.moyses.api_system_car.domain.repository.ServiceOrderRepository;
import com.moyses.api_system_car.domain.repository.UserRepository;
import com.moyses.api_system_car.infraestructure.persistence.entity.ServiceOrderEntity;
import com.moyses.api_system_car.infraestructure.persistence.mapper.ServiceOrderMapper;
import com.moyses.api_system_car.infraestructure.web.dto.serviceOrder.ServiceOrderRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ServiceOrderService {

    private final ServiceOrderRepository _repository;
    private final UserRepository _userRepository;
    private final CarRepository _carRepository;
    private final ServiceOrderMapper _mapper;

    public ServiceOrderService(ServiceOrderRepository repository, UserRepository userRepository, CarRepository carRepository, ServiceOrderMapper mapper) {
        _repository = repository;
        _userRepository = userRepository;
        _carRepository = carRepository;
        _mapper = mapper;
    }

    public ServiceOrderEntity createOrder(ServiceOrderRequest request){
        var user = _userRepository.findByEmail("");
        var car  = _carRepository.getCarsByUser(user.get());

        var entity = _mapper.toEntity(request);

        entity.setId(UUID.randomUUID());
        entity.setCar(car);
        entity.setUser(user.get());

        return  _repository.createOrder(entity);
    }
}
