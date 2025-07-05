package com.moyses.api_system_car.infraestructure.web.controller;

import com.moyses.api_system_car.application.service.ServiceAutomotiveService;
import com.moyses.api_system_car.infraestructure.integration.AutomotiveServiceClient;
import com.moyses.api_system_car.infraestructure.persistence.mapper.ServiceAutomotiveOrderMapper;
import com.moyses.api_system_car.infraestructure.web.dto.api.Response;
import com.moyses.api_system_car.infraestructure.web.dto.serviceOrder.ServiceAutomotiveOrderRequest;
import com.moyses.api_system_car.infraestructure.web.dto.serviceOrder.ServiceAutomotiveOrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("api/service-automotive")
public class ServiceAutomotiveController {

    private final AutomotiveServiceClient _serviceClient;

    @Autowired
    private static Logger _logger = Logger.getLogger(CarController.class.getName());
    private  final ServiceAutomotiveOrderMapper _mapper;
    private final ServiceAutomotiveService _orderService;

    public ServiceAutomotiveController(AutomotiveServiceClient serviceClient, ServiceAutomotiveOrderMapper mapper, ServiceAutomotiveService orderService) {
        _serviceClient = serviceClient;
        _mapper = mapper;
        _orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody ServiceAutomotiveOrderRequest orderRequest, @AuthenticationPrincipal UserDetails userDetails){
        try {
            var response = _orderService.createOrder(orderRequest, userDetails);
            return ResponseEntity.ok(Response.success("Ok", response));
        } catch (Exception e) {
            _logger.warning(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/available")
    public ResponseEntity<Response<List<ServiceAutomotiveOrderResponse>>> getServices(){
        try{
            _logger.info("Searching for available automotive services");
            var response = _orderService.getListServices();

            return ResponseEntity.ok(Response.success("ok", response));
        } catch (Exception e) {
            _logger.warning(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Response.error("Error", null));
        }
    }

    @GetMapping("/available/{id}")
    public ResponseEntity<Response<ServiceAutomotiveOrderResponse>> getServiceById(@PathVariable Integer id){
        try{
            _logger.info("Searching for automotive services by ID");
            var services = _orderService.getServiceById(id).get();

            return ResponseEntity.ok(Response.success("Ok", services));

        } catch (Exception e) {
            _logger.warning(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Response.error("Error", null));
        }
    }
}
