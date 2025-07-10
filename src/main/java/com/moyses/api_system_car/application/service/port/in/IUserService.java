package com.moyses.api_system_car.application.service.port.in;

import com.moyses.api_system_car.domain.model.User;
import com.moyses.api_system_car.infraestructure.web.dto.auth.RegisterRequest;

import java.util.Optional;

public interface IUserService {
    Optional<User> findByEmail(String email);
    User registerUser(RegisterRequest registerRequest);
}
