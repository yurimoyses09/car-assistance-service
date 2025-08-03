package com.moyses.api_system_car.domain.service.car;

import com.moyses.api_system_car.domain.model.Car;
import com.moyses.api_system_car.application.dto.car.CarRequest;
import org.springframework.security.core.userdetails.UserDetails;

public interface ICarService {
    Car registerCar(CarRequest request, UserDetails userDetails);
    Car getCarByUserId(UserDetails userDetails);
}
