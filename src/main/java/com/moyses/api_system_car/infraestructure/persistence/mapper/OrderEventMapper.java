package com.moyses.api_system_car.infraestructure.persistence.mapper;

import com.moyses.api_system_car.domain.model.User;
import com.moyses.api_system_car.application.dto.serviceOrder.ServiceAutomotiveOrderEvent;
import com.moyses.api_system_car.application.dto.serviceOrder.ServiceAutomotiveOrderRequest;
import org.springframework.stereotype.Component;

@Component
public class OrderEventMapper {

    public ServiceAutomotiveOrderEvent toEvent(ServiceAutomotiveOrderRequest request, User user){
        return ServiceAutomotiveOrderEvent.builder()
                .id_service(request.getId_service())
                .id_user(user.getId())
                .scheduled_date(request.getScheduled_date()).build();
    }
}
