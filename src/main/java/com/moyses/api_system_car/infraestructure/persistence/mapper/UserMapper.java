package com.moyses.api_system_car.infraestructure.persistence.mapper;

import com.moyses.api_system_car.infraestructure.persistence.entity.UserEntity;
import com.moyses.api_system_car.infraestructure.web.dto.auth.RegisterRequest;
import com.moyses.api_system_car.infraestructure.web.dto.user.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserEntity toEntity(RegisterRequest request){
        return UserEntity.builder()
                .name(request.getName())
                .age(request.getAge())
                .email(request.getEmail())
                .password(request.getPassword())
                .address(request.getAddress()).build();
    }

    public UserResponse toResponse(UserEntity userEntity) {
        return UserResponse.builder()
                .name(userEntity.getName())
                .age(userEntity.getAge())
                .email(userEntity.getEmail())
                .address(userEntity.getAddress()).build();
    }
}
