package com.moyses.api_system_car.infraestructure.persistence.repository.carRepository;

import com.moyses.api_system_car.domain.repository.CarRepository;
import com.moyses.api_system_car.infraestructure.persistence.entity.CarEntity;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class CarRepositoryImpl implements CarRepository {

    private final CarJpaRepository _carJpaRepository;

    public CarRepositoryImpl(CarJpaRepository carJpaRepository) {
        _carJpaRepository = carJpaRepository;
    }

    @Override
    public CarEntity registerCar(CarEntity entity) {
        return _carJpaRepository.save(entity);
    }

    @Override
    public CarEntity getCarsByIdUser(UUID idUser) {
        return _carJpaRepository.getCarsByUserId(idUser);
    }
}
