package com.moyses.api_system_car.domain.repository;

import com.moyses.api_system_car.infraestructure.persistence.entity.ServiceOrderEntity;

import java.util.List;
import java.util.UUID;

public interface ServiceOrderRepository {
    ServiceOrderEntity createOrder(ServiceOrderEntity entity);
    List<ServiceOrderEntity> findByCarId(UUID carId);
}
