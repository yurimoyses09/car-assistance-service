package com.moyses.api_system_car.infraestructure.persistence.repository.serviceOrder;

import com.moyses.api_system_car.domain.repository.IServiceOrderRepository;
import com.moyses.api_system_car.infraestructure.persistence.entity.ServiceOrderEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class ServiceOrderRepositoryImpl implements IServiceOrderRepository {

    private final IServiceOrderJpaRepository _jpaRepository;

    public ServiceOrderRepositoryImpl(IServiceOrderJpaRepository jpaRepository) {
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
