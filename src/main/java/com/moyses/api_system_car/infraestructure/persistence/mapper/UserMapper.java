package com.moyses.api_system_car.infraestructure.persistence.mapper;

import com.moyses.api_system_car.domain.model.User;
import com.moyses.api_system_car.infraestructure.persistence.entity.UserEntity;
import com.moyses.api_system_car.application.dto.auth.RegisterRequest;
import com.moyses.api_system_car.application.dto.user.UserResponse;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserMapper {
    public UserEntity toEntity(User user){
        return UserEntity.builder()
                .id(user.getId() == null ? UUID.randomUUID() : user.getId())
                .name(user.getName())
                .age(user.getAge())
                .email(user.getEmail())
                .password(user.getPassword())
                .address(user.getAddress()).build();
    }

    public UserResponse toResponse(User user) {
        return UserResponse.builder()
                .name(user.getName())
                .age(user.getAge())
                .email(user.getEmail())
                .address(user.getAddress()).build();
    }

    public User toModel(UserEntity entity){
        return User.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .address(entity.getAddress())
                .password(entity.getPassword())
                .age(entity.getAge()).build();
    }

    public User toModel(RegisterRequest request){
        return User.builder()
                .id(UUID.randomUUID())
                .name(request.getName())
                .email(request.getEmail())
                .address(request.getAddress())
                .password(request.getPassword())
                .age(request.getAge()).build();
    }
}
