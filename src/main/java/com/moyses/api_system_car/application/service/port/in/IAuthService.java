package com.moyses.api_system_car.application.service.port.in;

public interface IAuthService {
    String authenticateAndGenerateToken(String email, String password);
}
