package com.moyses.api_system_car.application.usecase.auth;

import com.moyses.api_system_car.application.dto.auth.LoginRequest;
import com.moyses.api_system_car.service.auth.AuthServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AuthUseCase {

    private final AuthServiceImpl _service;

    public AuthUseCase(AuthServiceImpl service) {
        _service = service;
    }

    public String execute(LoginRequest request){
        return _service.authenticateAndGenerateToken(request.getEmail(), request.getPassword());
    }
}
