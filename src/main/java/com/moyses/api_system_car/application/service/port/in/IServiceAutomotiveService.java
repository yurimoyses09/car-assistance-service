package com.moyses.api_system_car.application.service.port.in;

import com.moyses.api_system_car.domain.model.ServiceAutomotiveOrder;
import com.moyses.api_system_car.infraestructure.web.dto.serviceOrder.ServiceAutomotiveOrderRequest;
import com.moyses.api_system_car.infraestructure.web.dto.serviceOrder.ServiceAutomotiveOrderResponse;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IServiceAutomotiveService {
    ServiceAutomotiveOrder createOrder(ServiceAutomotiveOrderRequest request, UserDetails userDetails) throws IOException;
    List<ServiceAutomotiveOrderResponse> getListServices() throws IOException;
    Optional<ServiceAutomotiveOrderResponse> getServiceById(UUID id) throws IOException;
}
