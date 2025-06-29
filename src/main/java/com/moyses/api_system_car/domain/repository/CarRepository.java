package com.moyses.api_system_car.domain.repository;

import com.moyses.api_system_car.infraestructure.persistence.entity.CarEntity;

import java.util.UUID;

public interface CarRepository {
    CarEntity registerCar(CarEntity entity);
    CarEntity getCarsByIdUser(UUID idUser);
}