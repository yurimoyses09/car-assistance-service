package com.moyses.api_system_car.application.service;

import com.moyses.api_system_car.application.service.port.out.IOrderEventPublisher;
import com.moyses.api_system_car.infraestructure.messaging.OrderMessagePublisher;
import com.moyses.api_system_car.infraestructure.web.dto.serviceOrder.ServiceAutomotiveOrderEvent;
import org.springframework.stereotype.Service;

@Service
public class OrderEventPublisherService implements IOrderEventPublisher {

    private final OrderMessagePublisher _publisher;

    public OrderEventPublisherService(OrderMessagePublisher publisher) {
        _publisher = publisher;
    }

    @Override
    public void publish(ServiceAutomotiveOrderEvent order) {
        _publisher.publish(order);
    }
}
