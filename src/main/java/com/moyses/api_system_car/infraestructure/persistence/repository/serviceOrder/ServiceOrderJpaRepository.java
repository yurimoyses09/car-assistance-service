package com.moyses.api_system_car.infraestructure.persistence.repository.serviceOrder;

import com.moyses.api_system_car.infraestructure.persistence.entity.ServiceOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ServiceOrderJpaRepository extends JpaRepository<ServiceOrderEntity, UUID> {
    List<ServiceOrderEntity> findByCarId(UUID carId);
}
