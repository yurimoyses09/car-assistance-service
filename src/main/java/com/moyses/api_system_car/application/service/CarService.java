package com.moyses.api_system_car.application.service;

import com.moyses.api_system_car.application.service.port.in.ICarService;
import com.moyses.api_system_car.domain.model.Car;
import com.moyses.api_system_car.domain.repository.ICarRepository;
import com.moyses.api_system_car.domain.repository.IUserRepository;
import com.moyses.api_system_car.infraestructure.persistence.mapper.CarMapper;
import com.moyses.api_system_car.infraestructure.web.dto.car.CarRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class CarService implements ICarService {

    private final ICarRepository _carRepository;
    private final IUserRepository _userRepository;
    private final CarMapper _carMapper;

    public CarService(ICarRepository carRepository, IUserRepository userRepository, CarMapper carMapper) {
        _carRepository = carRepository;
        _userRepository = userRepository;
        _carMapper = carMapper;
    }

    public Car registerCar(CarRequest request, UserDetails userDetails) {
        var userEntity = _userRepository.findByEmail(userDetails.getUsername()).orElseThrow(() -> new RuntimeException("User NotFound"));
        var carMapper = _carMapper.toModel(request, userEntity);

        return _carRepository.registerCar(carMapper);
    }

    public Car getCarByUserId(UserDetails userDetails){
        var userEntity = _userRepository.findByEmail(userDetails.getUsername()).orElseThrow(() -> new RuntimeException("User NotFound"));
        return _carRepository.getCarByIdUser(userEntity.getId());
    }
}
