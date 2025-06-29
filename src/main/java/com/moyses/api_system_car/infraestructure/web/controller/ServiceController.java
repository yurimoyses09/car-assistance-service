package com.moyses.api_system_car.infraestructure.web.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.moyses.api_system_car.application.service.ServiceOrderService;
import com.moyses.api_system_car.infraestructure.persistence.mapper.ServiceOrderMapper;
import com.moyses.api_system_car.infraestructure.web.dto.serviceOrder.ServiceOrderRequest;
import com.moyses.api_system_car.infraestructure.web.dto.serviceOrder.ServiceOrderResponse;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
            return null;
        } catch (Exception e) {
            _logger.warning(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getServices(){
        try{
            _logger.info("Searching for available automotive services");
            return ResponseEntity.ok(_orderService.getListServices());
        } catch (Exception e) {
            _logger.warning(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getServiceById(@PathVariable Integer id){
        try{
            _logger.info("Searching for automotive services by ID");
            var services = _orderService.getServiceById(id);

            if (services.isPresent())
                return ResponseEntity.ok(services);

            _logger.info("Service not found");
            return ResponseEntity.notFound().build();

        } catch (Exception e) {
            _logger.warning(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
