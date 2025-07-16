package com.moyses.api_system_car.infraestructure.messaging;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moyses.api_system_car.application.service.ServiceAutomotiveService;
import com.moyses.api_system_car.infraestructure.web.controller.CarController;
import com.moyses.api_system_car.infraestructure.web.dto.serviceOrder.ServiceAutomotiveCreateOrder;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class OrderConsumer {

    @Autowired
    private static Logger _logger = Logger.getLogger(CarController.class.getName());
    private final ObjectMapper _mapper;

    private final ServiceAutomotiveService _service;

    public OrderConsumer(ObjectMapper mapper, ServiceAutomotiveService _service) {
        this._mapper = mapper;
        this._service = _service;
    }

    @RabbitListener(queues = "service.automotive.create")
    public void consume(String message){
        try {
            _logger.info("Message received from the queue: " + message);

            var mapper = _mapper.readValue(message, ServiceAutomotiveCreateOrder.class);

            _service.createOrder(mapper);
        } catch (Exception e) {
            _logger.warning("Error processing message: " + e.getMessage());
        }
    }
}
