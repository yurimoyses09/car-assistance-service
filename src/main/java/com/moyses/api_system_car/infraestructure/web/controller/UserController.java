package com.moyses.api_system_car.infraestructure.web.controller;

import com.moyses.api_system_car.application.service.UserService;
import com.moyses.api_system_car.domain.model.User;
import com.moyses.api_system_car.infraestructure.persistence.mapper.UserMapper;
import com.moyses.api_system_car.infraestructure.web.dto.api.Response;
import com.moyses.api_system_car.infraestructure.web.dto.auth.RegisterRequest;
import com.moyses.api_system_car.infraestructure.web.dto.user.UserResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("api/user")
public class UserController {

    private final UserService _service;
    private final UserMapper _mapper;

    @Autowired
    private static Logger _logger = Logger.getLogger(AuthController.class.getName());

    public UserController(UserService service, UserMapper mapper) {
        _service = service;
        _mapper = mapper;
    }

    @PostMapping("/register")
    public ResponseEntity<Response<UserResponse>> register(@RequestBody @Valid RegisterRequest request){
        _logger.info("registering user in the system");
        User registerUser = _service.registerUser(request);

        _logger.info("user registered successfully");
        return ResponseEntity.ok(Response.success("user registered successfully", _mapper.toResponse(registerUser)));
    }
}
