package com.moyses.api_system_car.infraestructure.web.controller;

import com.moyses.api_system_car.application.service.OrderEventPublisherService;
import com.moyses.api_system_car.application.service.ServiceAutomotiveService;
import com.moyses.api_system_car.application.service.UserService;
import com.moyses.api_system_car.infraestructure.persistence.mapper.OrderEventMapper;
import com.moyses.api_system_car.infraestructure.web.dto.api.Response;
import com.moyses.api_system_car.infraestructure.web.dto.serviceOrder.ServiceAutomotiveAvailableResponse;
import com.moyses.api_system_car.infraestructure.web.dto.serviceOrder.ServiceAutomotiveOrderRequest;
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
    private final ServiceAutomotiveService _orderService;
    public final OrderEventPublisherService _eventPublisher;
    public final OrderEventMapper _orderEventMapper;
    public final UserService _userService;

    public ServiceAutomotiveController(ServiceAutomotiveService orderService, OrderEventPublisherService eventPublisher, OrderEventMapper orderEventMapper, UserService userService) {
        _orderService = orderService;
        _eventPublisher = eventPublisher;
        _orderEventMapper = orderEventMapper;
        _userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody ServiceAutomotiveOrderRequest orderRequest, @AuthenticationPrincipal UserDetails userDetails){
        var isAvailable = _orderService.isDateAvailable(orderRequest.getScheduled_date(), orderRequest.getId_service());

        if(isAvailable.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Response.error("Service not found for the provided ID", null));

        if (!isAvailable.get())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Response.error("The requested data for the service is not available.", orderRequest));

        _logger.info("Generating automotive service event");
        var user = _userService.findByEmail(userDetails.getUsername()).get();
        _eventPublisher.publish(_orderEventMapper.toEvent(orderRequest, user));

        return ResponseEntity.ok(Response.success("Automotive service requested successfully, you will receive an email with the order details and confirmation.", null));
    }

    @GetMapping("/catalog")
    public ResponseEntity<Response<List<ServiceAutomotiveAvailableResponse>>> getServices(){
        _logger.info("Searching for available automotive services");
        var response = _orderService.getListServices();

        return ResponseEntity.ok(Response.success("ok", response));
    }

    @GetMapping("/catalog/{id}")
    public ResponseEntity<Response<ServiceAutomotiveAvailableResponse>> getServiceById(@PathVariable UUID id){
        _logger.info("Searching for automotive services by ID");

        return _orderService.getServiceById(id)
                .map(service -> ResponseEntity.ok(Response.success("Service Found", service)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(Response.error("Service NotFound", null)));
    }
}
