package com.moyses.api_system_car.infraestructure.persistence.mapper;

import com.moyses.api_system_car.domain.model.Car;
import com.moyses.api_system_car.domain.model.User;
import com.moyses.api_system_car.infraestructure.persistence.entity.CarEntity;
import com.moyses.api_system_car.infraestructure.persistence.entity.UserEntity;
import com.moyses.api_system_car.infraestructure.web.dto.car.CarRequest;
import com.moyses.api_system_car.infraestructure.web.dto.car.CarResponse;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CarMapper {

    private final UserMapper _userMapper;

    public CarMapper(UserMapper userMapper) {
        _userMapper = userMapper;
    }

    public CarEntity toEntity(Car car){
        return CarEntity.builder()
                .id(UUID.randomUUID())
                .model(car.getModel())
                .plate(car.getPlate())
                .year(car.getYear())
                .user(_userMapper.toEntity(car.getUser()))
                .build();
    }

    public Car toModel(CarRequest request, User user){
        return Car.builder()
                .model(request.getModel())
                .plate(request.getPlate())
                .year(request.getYear())
                .user(user)
                .id(UUID.randomUUID()).build();
    }

    public CarResponse ToResponse(Car car){
        return CarResponse.builder()
                .id(car.getId())
                .model(car.getModel())
                .year(car.getYear())
                .plate(car.getPlate()).build();
    }

    public Car ToModel(CarEntity entity){
        return Car.builder()
                .id(entity.getId())
                .plate(entity.getPlate())
                .year(entity.getYear())
                .model(entity.getModel()).build();
    }
}
