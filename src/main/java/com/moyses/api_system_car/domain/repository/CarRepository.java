package com.moyses.api_system_car.domain.repository;

import com.moyses.api_system_car.infraestructure.persistence.entity.CarEntity;
import com.moyses.api_system_car.infraestructure.persistence.entity.UserEntity;


public interface CarRepository {
    CarEntity registerCar(CarEntity entity);
    CarEntity getCarsByUser(UserEntity user);
}