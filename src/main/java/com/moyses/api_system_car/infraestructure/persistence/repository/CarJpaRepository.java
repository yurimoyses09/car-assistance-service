package com.moyses.api_system_car.infraestructure.persistence.repository;

import com.moyses.api_system_car.domain.model.User;
import com.moyses.api_system_car.infraestructure.persistence.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CarJpaRepository extends JpaRepository<CarEntity, UUID> {
    List<CarEntity> getCarsByUserEmail(User user);
}
