package com.moyses.api_system_car.application.usecase.order;

import com.moyses.api_system_car.application.dto.serviceOrder.ServiceAutomotiveCreateOrder;
import com.moyses.api_system_car.domain.model.ServiceAutomotiveOrder;
import com.moyses.api_system_car.infraestructure.persistence.mapper.OrderEventMapper;
import com.moyses.api_system_car.application.dto.api.Response;
import com.moyses.api_system_car.application.dto.serviceOrder.ServiceAutomotiveAvailableResponse;
import com.moyses.api_system_car.application.dto.serviceOrder.ServiceAutomotiveOrderRequest;
import com.moyses.api_system_car.service.order.OrderServiceImpl;
import com.moyses.api_system_car.service.user.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderAutomotiveCaseUse {

    private final OrderServiceImpl _service;

    public final OrderEventMapper _orderEventMapper;
    public final UserServiceImpl _userService;

    public OrderAutomotiveCaseUse(OrderServiceImpl service, OrderEventMapper orderEventMapper, UserServiceImpl userService) {
        _service = service;
        _orderEventMapper = orderEventMapper;
        _userService = userService;
    }

    public List<ServiceAutomotiveAvailableResponse> executeGetListServices(){
        return _service.getListServices();
    }

    public Optional<ServiceAutomotiveAvailableResponse> executeGetServiceById(UUID id){
        return _service.getServiceById(id);
    }

    public ResponseEntity<?> executeCreateEventOrder(ServiceAutomotiveOrderRequest orderRequest, UserDetails userDetails){
        var isAvailable = _service.isDateAvailable(orderRequest.getScheduled_date(), orderRequest.getId_service());

        if(isAvailable.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Response.error("Service not found for the provided ID", null));

        if (!isAvailable.get())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Response.error("The requested data for the service is not available.", orderRequest));

        var user = _userService.findByEmail(userDetails.getUsername()).get();
        _service.publishEvent(_orderEventMapper.toEvent(orderRequest, user));

        return ResponseEntity.ok(Response.success("Automotive service requested successfully, you will receive an email with the order details and confirmation.", null));
    }

    public ServiceAutomotiveOrder executeCreateOrder(ServiceAutomotiveCreateOrder request){
        return _service.createOrder(request);
    }
}
