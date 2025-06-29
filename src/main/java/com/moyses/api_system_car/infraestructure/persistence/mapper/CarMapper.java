package com.moyses.api_system_car.infraestructure.persistence.mapper;

import com.moyses.api_system_car.infraestructure.persistence.entity.CarEntity;
import com.moyses.api_system_car.infraestructure.persistence.entity.UserEntity;
import com.moyses.api_system_car.infraestructure.web.dto.car.CarRequest;
import com.moyses.api_system_car.infraestructure.web.dto.car.CarResponse;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CarMapper {

    public CarEntity toEntity(CarRequest request, UserEntity userEntity){
        return CarEntity.builder()
                .model(request.getModel())
                .plate(request.getPlate())
                .year(request.getYear())
                .user(userEntity)
                .id(UUID.randomUUID()).build();
    }

    public CarResponse ToResponse(CarEntity carEntity){
        return CarResponse.builder()
                .id(carEntity.getId())
                .model(carEntity.getModel())
                .year(carEntity.getYear())
                .plate(carEntity.getPlate()).build();
    }
}
