package com.moyses.api_system_car.infraestructure.persistence.repository.serviceOrder;

import com.moyses.api_system_car.infraestructure.persistence.entity.ServiceAutomotiveOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IServiceAutomotiveOrderJpaRepository extends JpaRepository<ServiceAutomotiveOrderEntity, UUID> {
    List<ServiceAutomotiveOrderEntity> findByCarId(UUID carId);
}
