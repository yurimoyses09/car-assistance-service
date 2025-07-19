package com.moyses.api_system_car.domain.service.order;

import com.moyses.api_system_car.domain.model.ServiceAutomotiveOrder;
import com.moyses.api_system_car.application.dto.serviceOrder.ServiceAutomotiveAvailableResponse;
import com.moyses.api_system_car.application.dto.serviceOrder.ServiceAutomotiveCreateOrder;
import com.moyses.api_system_car.application.dto.serviceOrder.ServiceAutomotiveOrderEvent;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IOrderAutomotiveService {

    ServiceAutomotiveOrder createOrder(ServiceAutomotiveCreateOrder request);
    List<ServiceAutomotiveAvailableResponse> getListServices();
    Optional<ServiceAutomotiveAvailableResponse> getServiceById(UUID id);
    Optional<Boolean> isDateAvailable(LocalDateTime dateTime, UUID id);

    void publishEvent(ServiceAutomotiveOrderEvent order);
}
