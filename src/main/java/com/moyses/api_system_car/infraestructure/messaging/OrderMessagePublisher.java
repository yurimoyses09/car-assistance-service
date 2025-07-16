package com.moyses.api_system_car.infraestructure.messaging;

import com.moyses.api_system_car.application.service.port.out.IOrderEventPublisher;
import com.moyses.api_system_car.infraestructure.config.RabbitMQConfig;
import com.moyses.api_system_car.infraestructure.web.dto.serviceOrder.ServiceAutomotiveOrderEvent;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderMessagePublisher implements IOrderEventPublisher {

    private final AmqpTemplate template;

    public OrderMessagePublisher(AmqpTemplate template) {
        this.template = template;
    }

    @Override
    public void publish(ServiceAutomotiveOrderEvent order) {
        template.convertAndSend(
                RabbitMQConfig.EXCHANGE_NAME,
                RabbitMQConfig.ROUTING_KEY,
                order
        );
    }
}
