package com.moyses.api_system_car.application.service;

import com.moyses.api_system_car.application.service.port.in.IAuthService;
import com.moyses.api_system_car.infraestructure.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthService {

    private final JwtTokenProvider _jwtTokenProvider;
    @Autowired
    private final AuthenticationManager _authenticationManager;

    public AuthService(JwtTokenProvider jwtTokenProvider, AuthenticationManager authenticationManager) {
        _jwtTokenProvider = jwtTokenProvider;
        _authenticationManager = authenticationManager;
    }

    public String authenticateAndGenerateToken(String email, String password){
        Authentication auth = _authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(email, password));

        UserDetails user = (UserDetails) auth.getPrincipal();

        return _jwtTokenProvider.generateToken(user);
    }
}
