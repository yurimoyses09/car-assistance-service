package com.moyses.api_system_car.service.car;

import com.moyses.api_system_car.domain.model.Car;
import com.moyses.api_system_car.domain.repository.ICarRepository;
import com.moyses.api_system_car.domain.repository.IUserRepository;
import com.moyses.api_system_car.domain.service.car.ICarService;
import com.moyses.api_system_car.infraestructure.persistence.mapper.CarMapper;
import com.moyses.api_system_car.application.dto.car.CarRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements ICarService {

    private final ICarRepository _carRepository;
    private final IUserRepository _userRepository;
    private final CarMapper _carMapper;

    public CarServiceImpl(ICarRepository carRepository, IUserRepository userRepository, CarMapper carMapper) {
        _carRepository = carRepository;
        _userRepository = userRepository;
        _carMapper = carMapper;
    }

    @Override
    public Car registerCar(CarRequest request, UserDetails userDetails) {
        var userEntity = _userRepository.findByEmail(userDetails.getUsername()).orElseThrow(() -> new RuntimeException("User NotFound"));
        var carMapper = _carMapper.toModel(request, userEntity);

        return _carRepository.registerCar(carMapper);
    }

    @Override
    public Car getCarByUserId(UserDetails userDetails) {
        var userEntity = _userRepository.findByEmail(userDetails.getUsername()).orElseThrow(() -> new RuntimeException("User NotFound"));
        return _carRepository.getCarByIdUser(userEntity.getId());
    }
}
