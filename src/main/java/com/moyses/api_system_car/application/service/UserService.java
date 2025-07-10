package com.moyses.api_system_car.application.service;

import com.moyses.api_system_car.application.service.port.in.IUserService;
import com.moyses.api_system_car.domain.model.User;
import com.moyses.api_system_car.domain.repository.IUserRepository;
import com.moyses.api_system_car.infraestructure.persistence.mapper.UserMapper;
import com.moyses.api_system_car.infraestructure.security.JwtTokenProvider;
import com.moyses.api_system_car.infraestructure.web.dto.auth.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {

    private final IUserRepository _repository;
    private final UserMapper _userMapper;

    @Autowired
    private final PasswordEncoder _passwordEncoder;

    public UserService(IUserRepository repository, UserMapper userMapper, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider) {
        _repository = repository;
        _userMapper = userMapper;
        _passwordEncoder = passwordEncoder;
    }

    public Optional<User> findByEmail(String email){
        return _repository.findByEmail(email);
    }

    public User registerUser(RegisterRequest registerRequest){
        Optional<User> user = _repository.findByEmail(registerRequest.getEmail());

        if (user.isPresent())
            throw new IllegalArgumentException("User Already Exists");

        registerRequest.setPassword(_passwordEncoder.encode(registerRequest.getPassword()));
        var entity = _userMapper.toModel(registerRequest);

        return _repository.registerUser(entity);
    }
}
