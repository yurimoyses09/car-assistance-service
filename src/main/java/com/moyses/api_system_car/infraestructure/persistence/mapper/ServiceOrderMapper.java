package com.moyses.api_system_car.infraestructure.persistence.mapper;

import com.moyses.api_system_car.infraestructure.persistence.entity.ServiceOrderEntity;
import com.moyses.api_system_car.infraestructure.web.dto.serviceOrder.ServiceOrderRequest;
import com.moyses.api_system_car.infraestructure.web.dto.serviceOrder.ServiceOrderResponse;
import org.springframework.stereotype.Component;

@Component
public class ServiceOrderMapper {

    public ServiceOrderEntity toEntity(ServiceOrderRequest orderRequest){
        return ServiceOrderEntity.builder()
                .name(orderRequest.getName())
                .description(orderRequest.getDescription())
                .scheduledDate(orderRequest.getScheduledDate()).build();
    }
}
