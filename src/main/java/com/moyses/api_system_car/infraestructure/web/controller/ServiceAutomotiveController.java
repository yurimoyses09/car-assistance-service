package com.moyses.api_system_car.infraestructure.web.controller;

import com.moyses.api_system_car.application.usecase.order.OrderAutomotiveCaseUse;
import com.moyses.api_system_car.application.dto.api.Response;
import com.moyses.api_system_car.application.dto.serviceOrder.ServiceAutomotiveAvailableResponse;
import com.moyses.api_system_car.application.dto.serviceOrder.ServiceAutomotiveOrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@RestController
@RequestMapping("api/service-automotive")
public class ServiceAutomotiveController {

    @Autowired
    private static Logger _logger = Logger.getLogger(CarController.class.getName());

    private final OrderAutomotiveCaseUse _orderService;

    public ServiceAutomotiveController(OrderAutomotiveCaseUse orderService) {
        _orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody ServiceAutomotiveOrderRequest orderRequest, @AuthenticationPrincipal UserDetails userDetails){
        return _orderService.executeCreateEventOrder(orderRequest, userDetails);
    }

    @GetMapping("/catalog")
    public ResponseEntity<Response<List<ServiceAutomotiveAvailableResponse>>> getServices(){
        _logger.info("Searching for available automotive services");
        var response = _orderService.executeGetListServices();
        return ResponseEntity.ok(Response.success("ok", response));
    }

    @GetMapping("/catalog/{id}")
    public ResponseEntity<Response<ServiceAutomotiveAvailableResponse>> getServiceById(@PathVariable UUID id){
        _logger.info("Searching for automotive services by ID");

        return _orderService.executeGetServiceById(id)
                .map(service -> ResponseEntity.ok(Response.success("Service Found", service)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(Response.error("Service NotFound", null)));
    }
}
