package com.moyses.api_system_car.domain.repository;

import com.moyses.api_system_car.domain.model.Car;

import java.util.UUID;

public interface ICarRepository {
    Car registerCar(Car car);
    Car getCarByIdUser(UUID idUser);
}