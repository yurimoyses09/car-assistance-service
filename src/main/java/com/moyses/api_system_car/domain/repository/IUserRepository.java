package com.moyses.api_system_car.domain.repository;

import com.moyses.api_system_car.domain.model.User;

import java.util.Optional;
import java.util.UUID;

public interface IUserRepository {
    Optional<User> findByEmail(String email);
    Optional<User> findById(UUID id);
    User registerUser(User user);
}