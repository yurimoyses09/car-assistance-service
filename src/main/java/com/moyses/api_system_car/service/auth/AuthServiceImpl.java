package com.moyses.api_system_car.service.auth;

import com.moyses.api_system_car.domain.service.auth.IAuthService;
import com.moyses.api_system_car.infraestructure.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements IAuthService {

    @Autowired
    private final AuthenticationManager _authenticationManager;
    private final JwtTokenProvider _jwtTokenProvider;

    public AuthServiceImpl(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider) {
        _authenticationManager = authenticationManager;
        _jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public String authenticateAndGenerateToken(String email, String password) {
        Authentication authentication = _authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(email, password));

        UserDetails user = (UserDetails) authentication.getPrincipal();

        return _jwtTokenProvider.generateToken(user);
    }
}
