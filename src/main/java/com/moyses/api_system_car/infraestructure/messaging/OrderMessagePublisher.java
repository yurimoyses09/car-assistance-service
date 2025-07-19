package com.moyses.api_system_car.infraestructure.messaging;

import com.moyses.api_system_car.infraestructure.config.RabbitMQConfig;
import com.moyses.api_system_car.application.dto.serviceOrder.ServiceAutomotiveOrderEvent;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderMessagePublisher {

    private final AmqpTemplate template;

    public OrderMessagePublisher(AmqpTemplate template) {
        this.template = template;
    }

    public void publish(ServiceAutomotiveOrderEvent order) {
        template.convertAndSend(
                RabbitMQConfig.EXCHANGE_NAME,
                RabbitMQConfig.ROUTING_KEY,
                order
        );
    }
}
