package com.moyses.api_system_car.domain.service.auth;

public interface IAuthService {
    String authenticateAndGenerateToken(String email, String password);
}
