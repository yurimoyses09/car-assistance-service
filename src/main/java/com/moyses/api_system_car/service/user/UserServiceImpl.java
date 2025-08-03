package com.moyses.api_system_car.service.user;

import com.moyses.api_system_car.domain.model.User;
import com.moyses.api_system_car.domain.repository.IUserRepository;
import com.moyses.api_system_car.domain.service.user.IUserService;
import com.moyses.api_system_car.infraestructure.persistence.mapper.UserMapper;
import com.moyses.api_system_car.application.dto.auth.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    private final IUserRepository _userRepository;
    private final UserMapper _userMapper;

    @Autowired
    private final PasswordEncoder _passwordEncoder;

    public UserServiceImpl(IUserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        _userRepository = userRepository;
        _userMapper = userMapper;
        _passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return _userRepository.findByEmail(email);
    }

    @Override
    public User registerUser(RegisterRequest registerRequest) {
        Optional<User> user = _userRepository.findByEmail(registerRequest.getEmail());

        if (user.isPresent())
            throw new IllegalArgumentException("User Already Exists");

        registerRequest.setPassword(_passwordEncoder.encode(registerRequest.getPassword()));
        var entity = _userMapper.toModel(registerRequest);

        return _userRepository.registerUser(entity);
    }
}
