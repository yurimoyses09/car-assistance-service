package com.moyses.api_system_car.infraestructure.persistence.repository.carRepository;

import com.moyses.api_system_car.domain.repository.CarRepository;
import com.moyses.api_system_car.infraestructure.persistence.entity.CarEntity;
import com.moyses.api_system_car.infraestructure.persistence.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarRepositoryImpl implements CarRepository {

    private final CarJpaRepository _carJpaRepository;

    public CarRepositoryImpl(CarJpaRepository carJpaRepository) {
        _carJpaRepository = carJpaRepository;
    }

    public CarEntity registerCar(CarEntity entity){
        return _carJpaRepository.save(entity);
    }

    @Override
    public CarEntity getCarsByUser(UserEntity user) {
        return _carJpaRepository.getCarsByUserEmail(user);
    }
}
