package com.moyses.api_system_car.infraestructure.persistence.repository;

import com.moyses.api_system_car.domain.model.User;
import com.moyses.api_system_car.domain.repository.CarRepository;
import com.moyses.api_system_car.infraestructure.persistence.entity.CarEntity;
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

    public List<CarEntity> getCarsByUser(User user){
        return _carJpaRepository.getCarsByUserEmail(user);
    }
}
