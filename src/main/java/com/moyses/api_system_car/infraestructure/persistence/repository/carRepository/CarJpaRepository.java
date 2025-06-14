package com.moyses.api_system_car.infraestructure.persistence.repository.carRepository;

import com.moyses.api_system_car.infraestructure.persistence.entity.CarEntity;
import com.moyses.api_system_car.infraestructure.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CarJpaRepository extends JpaRepository<CarEntity, UUID> {
    CarEntity getCarsByUserEmail(UserEntity user);
}
