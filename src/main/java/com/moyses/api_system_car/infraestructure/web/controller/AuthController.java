package com.moyses.api_system_car.infraestructure.web.controller;

import com.moyses.api_system_car.application.usecase.auth.AuthUseCase;
import com.moyses.api_system_car.application.dto.api.Response;
import com.moyses.api_system_car.application.dto.auth.JwtResponse;
import com.moyses.api_system_car.application.dto.auth.LoginRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    private final AuthUseCase _authUseCase;

    @Autowired
    private static Logger _logger = Logger.getLogger(AuthController.class.getName());

    public AuthController(AuthUseCase authUseCase) {
        _authUseCase = authUseCase;
    }

    @PostMapping("/login")
    public ResponseEntity<Response<JwtResponse>> login(@RequestBody @Valid LoginRequest request){
        _logger.info("authenticating user in the system");
        var response = _authUseCase.execute(request);

        _logger.info("token generated successfully");
        return ResponseEntity.ok(Response.success("token generated successfully", new JwtResponse((response))));
    }
}
