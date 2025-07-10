package com.moyses.api_system_car.infraestructure.persistence.mapper;

import com.moyses.api_system_car.domain.model.Car;
import com.moyses.api_system_car.domain.model.ServiceAutomotiveOrder;
import com.moyses.api_system_car.domain.model.User;
import com.moyses.api_system_car.infraestructure.persistence.entity.ServiceAutomotiveOrderEntity;
import com.moyses.api_system_car.infraestructure.web.dto.serviceOrder.ServiceAutomotiveOrderRequest;
import com.moyses.api_system_car.infraestructure.web.dto.serviceOrder.ServiceAutomotiveOrderResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.UUID;

@Component
public class ServiceAutomotiveOrderMapper {

    private final CarMapper _carMapper;
    private final UserMapper _userMapper;

    public ServiceAutomotiveOrderMapper(CarMapper carMapper, UserMapper userMapper) {
        _carMapper = carMapper;
        _userMapper = userMapper;
    }

    public ServiceAutomotiveOrderResponse toResponse(ServiceAutomotiveOrder serviceAutomotiveOrder){
        return ServiceAutomotiveOrderResponse.builder()
                .id(serviceAutomotiveOrder.getId())
                .name(serviceAutomotiveOrder.getName())
                .available_data(Collections.singletonList(serviceAutomotiveOrder.getScheduledDate()))
                .price(serviceAutomotiveOrder.getPrice())
                .description(serviceAutomotiveOrder.getDescription()).build();
    }

    public ServiceAutomotiveOrder toModel (Car car, User user, ServiceAutomotiveOrderRequest request, ServiceAutomotiveOrderResponse response){
        return ServiceAutomotiveOrder.builder()
                .id(UUID.randomUUID())
                .name(response.getName())
                .description(response.getDescription())
                .price(response.getPrice())
                .scheduledDate(request.getScheduled_date())
                .car(car)
                .user(user).build();
    }

    public ServiceAutomotiveOrderEntity toEntity(ServiceAutomotiveOrder serviceAutomotiveOrder){
        return ServiceAutomotiveOrderEntity.builder()
                .id(UUID.randomUUID())
                .name(serviceAutomotiveOrder.getName())
                .description(serviceAutomotiveOrder.getDescription())
                .price(serviceAutomotiveOrder.getPrice())
                .scheduledDate(serviceAutomotiveOrder.getScheduledDate())
                .createdAt(LocalDateTime.now())
                .car(_carMapper.toEntity(serviceAutomotiveOrder.getCar()))
                .user(_userMapper.toEntity(serviceAutomotiveOrder.getUser())).build();
    }

    public ServiceAutomotiveOrder toModel (ServiceAutomotiveOrderEntity entity){
        return ServiceAutomotiveOrder.builder()
                .id(UUID.randomUUID())
                .name(entity.getName())
                .description(entity.getDescription())
                .price(entity.getPrice())
                .scheduledDate(entity.getScheduledDate())
                .createAt(entity.getCreatedAt())
                .car(_carMapper.toModel(entity.getCar()))
                .user(_userMapper.toModel(entity.getUser())).build();
    }
}
