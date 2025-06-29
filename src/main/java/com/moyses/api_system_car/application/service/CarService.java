package com.moyses.api_system_car.application.service;

import com.moyses.api_system_car.domain.model.Car;
import com.moyses.api_system_car.domain.repository.CarRepository;
import com.moyses.api_system_car.domain.repository.UserRepository;
import com.moyses.api_system_car.infraestructure.persistence.mapper.CarMapper;
import com.moyses.api_system_car.infraestructure.web.dto.car.CarRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    private final CarRepository _carRepository;
    private final UserRepository _userRepository;
    private final CarMapper _carMapper;

    public CarService(CarRepository carRepository, UserRepository userRepository, CarMapper carMapper) {
        _carRepository = carRepository;
        _userRepository = userRepository;
        _carMapper = carMapper;
    }

    public Car registerCar(CarRequest request, UserDetails userDetails) {
        var userEntity = _userRepository.findByEmail(userDetails.getUsername()).orElseThrow(() -> new RuntimeException("User NotFound"));
        var entity = _carMapper.toEntity(request, userEntity);
        var response = _carRepository.registerCar(entity);

        return _carMapper.ToModel(response);
    }

    public Car getCarByUserId(UserDetails userDetails){
        var userEntity = _userRepository.findByEmail(userDetails.getUsername()).orElseThrow(() -> new RuntimeException("User NotFound"));
        var response = _carRepository.getCarsByIdUser(userEntity.getId());

        return _carMapper.ToModel(response);
    }
}
