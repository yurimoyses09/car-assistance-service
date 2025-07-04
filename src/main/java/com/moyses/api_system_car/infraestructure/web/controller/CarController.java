package com.moyses.api_system_car.infraestructure.web.controller;

import com.moyses.api_system_car.application.service.CarService;
import com.moyses.api_system_car.infraestructure.persistence.mapper.CarMapper;
import com.moyses.api_system_car.infraestructure.web.dto.api.Response;
import com.moyses.api_system_car.infraestructure.web.dto.car.CarRequest;
import com.moyses.api_system_car.infraestructure.web.dto.car.CarResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("api/car")
public class CarController {

    private final CarService _carService;
    private final CarMapper _carMapper;

    @Autowired
    private static Logger _logger = Logger.getLogger(CarController.class.getName());

    public CarController(CarService carService, CarMapper carMapper) {
        _carService = carService;
        _carMapper = carMapper;
    }

    @PostMapping
    public ResponseEntity<Response<CarResponse>> registerCar(@RequestBody CarRequest request, @AuthenticationPrincipal UserDetails userDetails){
        _logger.info("registering user's car in the system");
        var response = _carService.registerCar(request, userDetails);

        _logger.info("car registered successfully");
        return ResponseEntity.ok(Response.success("car registered successfully", _carMapper.ToResponse(response)));
    }

    @GetMapping
    public ResponseEntity<Response<CarResponse>> getCarByUser(@AuthenticationPrincipal UserDetails userDetails){
        _logger.info("searching for car in user");
        var response = _carService.getCarByUserId(userDetails);

        _logger.info("car found successfully");
        return ResponseEntity.ok(Response.success("car found successfully", _carMapper.ToResponse(response)));
    }
}
