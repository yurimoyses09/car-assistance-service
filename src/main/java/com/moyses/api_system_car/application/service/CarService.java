package com.moyses.api_system_car.application.service;

import com.moyses.api_system_car.domain.repository.CarRepository;
import com.moyses.api_system_car.domain.repository.UserRepository;
import com.moyses.api_system_car.infraestructure.persistence.entity.CarEntity;
import com.moyses.api_system_car.infraestructure.persistence.entity.UserEntity;
import com.moyses.api_system_car.infraestructure.persistence.mapper.CarMapper;
import com.moyses.api_system_car.infraestructure.web.dto.Car.CarRequest;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public CarEntity registerCar(CarRequest request, Authentication authentication) {
        Optional<UserEntity> user = Optional.ofNullable(_userRepository.findByEmail(authentication.name()).orElseThrow(() -> new RuntimeException("User NotFound")));;

        var entity = _carMapper.toEntity(request);
        entity.setUser(user.get());

        return _carRepository.registerCar(entity);

    }
}
