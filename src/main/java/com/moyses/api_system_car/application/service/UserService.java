package com.moyses.api_system_car.application.service;

import com.moyses.api_system_car.domain.repository.UserRepository;
import com.moyses.api_system_car.infraestructure.persistence.entity.UserEntity;
import com.moyses.api_system_car.infraestructure.persistence.mapper.UserMapper;
import com.moyses.api_system_car.infraestructure.web.dto.Auth.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository _repository;
    private final UserMapper _userMapper;
    @Autowired
    private final PasswordEncoder _passwordEncoder;

    public UserService(UserRepository repository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        _repository = repository;
        _userMapper = userMapper;
        _passwordEncoder = passwordEncoder;
    }

    public Optional<UserEntity> findByEmail(String email){
        return _repository.findByEmail(email);
    }

    public UserEntity registerUser(RegisterRequest registerRequest) throws Exception {

        if (_repository.findByEmail(registerRequest.getEmail()).isPresent())
            throw new Exception("User already exists");

        registerRequest.setPassword(_passwordEncoder.encode(registerRequest.getPassword()));

        var entity = _userMapper.toEntity(registerRequest);

        return _repository.registerUser(entity);
    }
}
