package com.moyses.api_system_car.infraestructure.web.controller;

import com.moyses.api_system_car.application.service.UserService;
import com.moyses.api_system_car.infraestructure.persistence.entity.UserEntity;
import com.moyses.api_system_car.infraestructure.persistence.mapper.UserMapper;
import com.moyses.api_system_car.infraestructure.security.JwtTokenProvider;
import com.moyses.api_system_car.infraestructure.web.dto.Auth.JwtResponse;
import com.moyses.api_system_car.infraestructure.web.dto.Auth.LoginRequest;
import com.moyses.api_system_car.infraestructure.web.dto.Auth.RegisterRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    private final UserService _userService;
    private final UserMapper _userMapper;
    private static Logger _logger = Logger.getLogger(AuthController.class.getName());

    @Autowired
    private final AuthenticationManager _authenticationManager;
    private final JwtTokenProvider _jwtTokenProvider;

    public AuthController(UserService userService, UserMapper userMapper, Logger logger, AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider) {
        _userService = userService;
        _userMapper = userMapper;
        _authenticationManager = authenticationManager;
        _jwtTokenProvider = jwtTokenProvider;
        _logger = logger;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterRequest request){
        try {
            _logger.info("registering user in the system");
            UserEntity entity = _userService.registerUser(request);

            _logger.info("user registered successfully");
            return ResponseEntity.ok(_userMapper.toResponse(entity));

        }catch (Exception ex)
        {
            _logger.warning(ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @PostMapping("/login")
    public JwtResponse login(@RequestBody @Valid LoginRequest request){
        try{
            _logger.info("authenticating user in the system");
            Authentication auth = _authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

            _logger.info("generating token for the user");
            UserDetails user = (UserDetails) auth.getPrincipal();
            String token = _jwtTokenProvider.generateToken(user);

            _logger.info("token generated successfully");
            return ResponseEntity.ok(new JwtResponse(token)).getBody();
        } catch (Exception ex) {
            _logger.warning(ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JwtResponse(ex.getMessage())).getBody();
        }
    }
}
