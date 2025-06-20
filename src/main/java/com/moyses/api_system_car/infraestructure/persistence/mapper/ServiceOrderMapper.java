package com.moyses.api_system_car.infraestructure.persistence.mapper;

import com.moyses.api_system_car.infraestructure.persistence.entity.ServiceOrderEntity;
import com.moyses.api_system_car.infraestructure.web.dto.serviceOrder.ServiceOrderRequest;
import com.moyses.api_system_car.infraestructure.web.dto.serviceOrder.ServiceOrderResponse;
import org.springframework.stereotype.Component;

@Component
public class ServiceOrderMapper {

    public ServiceOrderEntity toEntity(ServiceOrderRequest orderRequest){
        return new ServiceOrderEntity(
                orderRequest.getType(),
                orderRequest.getDescription(),
                orderRequest.getScheduledDate()
        );
    }

    public ServiceOrderResponse toResponse(ServiceOrderEntity entity){
        return new ServiceOrderResponse(
                entity.getId(),
                entity.getType(),
                entity.getDescription(),
                entity.getScheduledDate()
        );
    }
}
