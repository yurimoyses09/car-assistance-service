package com.moyses.api_system_car.domain.repository;

import com.moyses.api_system_car.domain.model.User;

import java.util.Optional;

public interface IUserRepository {
    Optional<User> findByEmail(String email);
    User registerUser(User user);
}