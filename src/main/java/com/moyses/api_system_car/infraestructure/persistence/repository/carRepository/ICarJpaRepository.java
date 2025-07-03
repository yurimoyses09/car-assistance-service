package com.moyses.api_system_car.infraestructure.persistence.repository.carRepository;

import com.moyses.api_system_car.infraestructure.persistence.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ICarJpaRepository extends JpaRepository<CarEntity, UUID> {
    CarEntity getCarsByUserId(UUID idUser);
}
