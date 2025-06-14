package com.moyses.api_system_car.infraestructure.persistence.repository.serviceOrder;

import com.moyses.api_system_car.domain.repository.ServiceOrderRepository;
import com.moyses.api_system_car.infraestructure.persistence.entity.ServiceOrderEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class ServiceOrderRepositoryImpl implements ServiceOrderRepository {

    private final ServiceOrderJpaRepository _jpaRepository;

    public ServiceOrderRepositoryImpl(ServiceOrderJpaRepository jpaRepository) {
        _jpaRepository = jpaRepository;
    }

    @Override
    public ServiceOrderEntity createOrder(ServiceOrderEntity entity) {
        return _jpaRepository.save(entity);
    }

    @Override
    public List<ServiceOrderEntity> findByCarId(UUID carId) {
        return List.of();
    }
}
