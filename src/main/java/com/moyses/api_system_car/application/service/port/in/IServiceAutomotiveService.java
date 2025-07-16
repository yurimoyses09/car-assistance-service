package com.moyses.api_system_car.application.service.port.in;

import com.moyses.api_system_car.domain.model.ServiceAutomotiveOrder;
import com.moyses.api_system_car.infraestructure.web.dto.serviceOrder.ServiceAutomotiveAvailableResponse;
import com.moyses.api_system_car.infraestructure.web.dto.serviceOrder.ServiceAutomotiveCreateOrder;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IServiceAutomotiveService {
    ServiceAutomotiveOrder createOrder(ServiceAutomotiveCreateOrder request) throws IOException;
    List<ServiceAutomotiveAvailableResponse> getListServices() throws IOException;
    Optional<ServiceAutomotiveAvailableResponse> getServiceById(UUID id) throws IOException;
    Optional<Boolean> isDateAvailable(LocalDateTime dateTime, UUID id) throws IOException;
}
