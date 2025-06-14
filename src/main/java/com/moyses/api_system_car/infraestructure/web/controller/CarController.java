package com.moyses.api_system_car.infraestructure.web.controller;

import com.moyses.api_system_car.application.service.CarService;
import com.moyses.api_system_car.infraestructure.persistence.mapper.CarMapper;
import com.moyses.api_system_car.infraestructure.web.dto.car.CarRequest;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<?> registerCar(@RequestBody CarRequest request, Authentication authentication){
        try{
            _logger.info("registering user's car in the system");
            var response = _carService.registerCar(request, authentication);

            var dto = _carMapper.ToResponse(response);

            _logger.info("car registered successfully");
            return ResponseEntity.ok(dto);

        } catch (Exception ex) {
            _logger.info(ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}
