package com.moyses.api_system_car.infraestructure.persistence.repository;

import com.moyses.api_system_car.domain.repository.UserRepository;
import com.moyses.api_system_car.infraestructure.persistence.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository _jpaRepository;

    public UserRepositoryImpl(UserJpaRepository jpaRepository) {
        this._jpaRepository = jpaRepository;
    }

    @Override
    public Optional<UserEntity> findByEmail(String email){
        return _jpaRepository.findByEmail(email);
    }

    @Override
    public UserEntity registerUser(UserEntity userEntity){
        return _jpaRepository.save(userEntity);
    }
}
