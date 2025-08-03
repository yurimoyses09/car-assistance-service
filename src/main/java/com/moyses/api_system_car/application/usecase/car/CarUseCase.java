package com.moyses.api_system_car.application.usecase.car;

import com.moyses.api_system_car.infraestructure.persistence.mapper.CarMapper;
import com.moyses.api_system_car.application.dto.car.CarRequest;
import com.moyses.api_system_car.application.dto.car.CarResponse;
import com.moyses.api_system_car.service.car.CarServiceImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class CarUseCase {

    private final CarServiceImpl _service;
    private final CarMapper _carMapper;

    public CarUseCase(CarServiceImpl service, CarMapper carMapper) {
        _service = service;
        _carMapper = carMapper;
    }

    public CarResponse registerCar(CarRequest request, UserDetails userDetails){
        var response = _service.registerCar(request, userDetails);
        return _carMapper.ToResponse(response);
    }

    public CarResponse getCarByUserId(UserDetails userDetails){
        var response = _service.getCarByUserId(userDetails);
        return _carMapper.ToResponse(response);
    }
}
