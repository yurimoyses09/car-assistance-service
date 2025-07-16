package com.moyses.api_system_car.application.service.port.out;

import com.moyses.api_system_car.infraestructure.web.dto.serviceOrder.ServiceAutomotiveOrderEvent;

public interface IOrderEventPublisher {
    void publish(ServiceAutomotiveOrderEvent order);
}
