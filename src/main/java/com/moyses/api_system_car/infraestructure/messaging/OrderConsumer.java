package com.moyses.api_system_car.infraestructure.messaging;

import com.moyses.api_system_car.application.usecase.order.OrderAutomotiveCaseUse;
import com.moyses.api_system_car.application.dto.serviceOrder.ServiceAutomotiveCreateOrder;
import com.moyses.api_system_car.infraestructure.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class OrderConsumer {

    @Autowired
    private static Logger _logger = Logger.getLogger(OrderConsumer.class.getName());

    private final OrderAutomotiveCaseUse _service;

    public OrderConsumer(OrderAutomotiveCaseUse service) {
        _service = service;
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void consume(ServiceAutomotiveCreateOrder order){
        try {
            _logger.info("Message received from the queue");

            _service.executeCreateOrder(order);
        } catch (Exception e) {
            _logger.warning("Error processing message: " + e.getMessage());
        }
    }
}
