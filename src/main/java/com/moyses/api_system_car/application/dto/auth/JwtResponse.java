package com.moyses.api_system_car.application.dto.auth;

public class JwtResponse {

    private final String token;

    public JwtResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
