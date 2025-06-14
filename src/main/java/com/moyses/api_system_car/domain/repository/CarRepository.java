package com.moyses.api_system_car.domain.repository;

import com.moyses.api_system_car.domain.model.User;
import com.moyses.api_system_car.infraestructure.persistence.entity.CarEntity;

import java.util.List;

public interface CarRepository {
    CarEntity registerCar(CarEntity entity);
    List<CarEntity> getCarsByUser(User user);
}