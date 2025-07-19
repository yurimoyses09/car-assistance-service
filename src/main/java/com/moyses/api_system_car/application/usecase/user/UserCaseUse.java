package com.moyses.api_system_car.application.usecase.user;

import com.moyses.api_system_car.infraestructure.persistence.mapper.UserMapper;
import com.moyses.api_system_car.application.dto.auth.RegisterRequest;
import com.moyses.api_system_car.application.dto.user.UserResponse;
import com.moyses.api_system_car.service.user.UserServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserCaseUse {

    private final UserServiceImpl _service;
    private final UserMapper _userMapper;

    public UserCaseUse(UserServiceImpl service, UserMapper userMapper) {
        _service = service;
        _userMapper = userMapper;
    }

    public UserResponse registerUser(RegisterRequest request){
        var response = _service.registerUser(request);
        return _userMapper.toResponse(response);
    }
}
