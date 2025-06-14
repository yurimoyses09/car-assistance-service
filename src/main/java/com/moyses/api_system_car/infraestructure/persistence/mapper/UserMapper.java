package com.moyses.api_system_car.infraestructure.persistence.mapper;

import com.moyses.api_system_car.infraestructure.persistence.entity.UserEntity;
import com.moyses.api_system_car.infraestructure.web.dto.auth.RegisterRequest;
import com.moyses.api_system_car.infraestructure.web.dto.user.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserEntity toEntity(RegisterRequest request){
        return new UserEntity(
                request.getName(),
                request.getAge(),
                request.getEmail(),
                request.getPassword(),
                request.getAddress());
    }

    public UserResponse toResponse(UserEntity userEntity) {
        return new UserResponse(
                userEntity.getName(),
                userEntity.getAge(),
                userEntity.getEmail(),
                userEntity.getAddress());
    }
}
