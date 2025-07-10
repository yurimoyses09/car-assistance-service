package com.moyses.api_system_car.application.service.port.in;

import com.moyses.api_system_car.domain.model.Car;
import com.moyses.api_system_car.infraestructure.web.dto.car.CarRequest;
import org.springframework.security.core.userdetails.UserDetails;

public interface ICarService  {
    Car registerCar(CarRequest request, UserDetails userDetails);
    Car getCarByUserId(UserDetails userDetails);
}
