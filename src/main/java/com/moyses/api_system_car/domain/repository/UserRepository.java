package com.moyses.api_system_car.domain.repository;

import com.moyses.api_system_car.infraestructure.persistence.entity.UserEntity;

import java.util.Optional;

public interface UserRepository {
    Optional<UserEntity> findByEmail(String email);
    UserEntity registerUser(UserEntity userEntity);
}