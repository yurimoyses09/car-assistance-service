package com.moyses.api_system_car.infraestructure.persistence.repository.userRepository;

import com.moyses.api_system_car.domain.model.User;
import com.moyses.api_system_car.domain.repository.IUserRepository;
import com.moyses.api_system_car.infraestructure.persistence.mapper.UserMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements IUserRepository {

    private final IUserJpaRepository _jpaRepository;
    private final UserMapper _mapper;

    public UserRepositoryImpl(IUserJpaRepository jpaRepository, UserMapper mapper) {
        this._jpaRepository = jpaRepository;
        _mapper = mapper;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return _jpaRepository.findByEmail(email)
                .map(_mapper::toModel);
    }

    @Override
    public User registerUser(User user) {
        var entity = _jpaRepository.save(_mapper.toEntity(user));
        return _mapper.toModel(entity);
    }
}
