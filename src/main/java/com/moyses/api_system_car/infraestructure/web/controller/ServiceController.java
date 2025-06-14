package com.moyses.api_system_car.infraestructure.web.controller;

import com.moyses.api_system_car.application.service.ServiceOrderService;
import com.moyses.api_system_car.infraestructure.persistence.mapper.ServiceOrderMapper;
import com.moyses.api_system_car.infraestructure.web.dto.serviceOrder.ServiceOrderRequest;
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
@RequestMapping("api/service-orders")
public class ServiceController {

    @Autowired
    private static Logger _logger = Logger.getLogger(CarController.class.getName());
    private  final ServiceOrderMapper _mapper;
    private final ServiceOrderService _orderService;

    public ServiceController(ServiceOrderMapper mapper, ServiceOrderService orderService) {
        _mapper = mapper;
        _orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody ServiceOrderRequest orderRequest, Authentication authentication){
        try {
            var response = _orderService.createOrder(orderRequest);
            return ResponseEntity.ok(_mapper.toResponse(response));
        } catch (Exception e) {
            _logger.warning(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
