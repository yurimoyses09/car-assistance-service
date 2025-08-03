package com.moyses.api_system_car.domain.service.user;

import com.moyses.api_system_car.domain.model.User;
import com.moyses.api_system_car.application.dto.auth.RegisterRequest;

import java.util.Optional;

public interface IUserService {
    Optional<User> findByEmail(String email);
    User registerUser(RegisterRequest registerRequest);
}
