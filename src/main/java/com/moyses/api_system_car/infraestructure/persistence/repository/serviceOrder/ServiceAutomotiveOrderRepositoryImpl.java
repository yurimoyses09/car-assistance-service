package com.moyses.api_system_car.infraestructure.persistence.repository.serviceOrder;

import com.moyses.api_system_car.domain.model.ServiceAutomotiveOrder;
import com.moyses.api_system_car.domain.repository.IServiceAutomotiveRepository;
import com.moyses.api_system_car.infraestructure.persistence.mapper.ServiceAutomotiveOrderMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class ServiceAutomotiveOrderRepositoryImpl implements IServiceAutomotiveRepository {

    private final IServiceAutomotiveOrderJpaRepository _jpaRepository;
    private final ServiceAutomotiveOrderMapper _mapper;

    public ServiceAutomotiveOrderRepositoryImpl(IServiceAutomotiveOrderJpaRepository jpaRepository, ServiceAutomotiveOrderMapper mapper) {
        _jpaRepository = jpaRepository;
        _mapper = mapper;
    }

    @Override
    public ServiceAutomotiveOrder createOrder(ServiceAutomotiveOrder model) {
       var entity = _mapper.toEntity(model);
       var response = _jpaRepository.save(entity);

       return _mapper.toModel(response);
    }

    @Override
    public List<ServiceAutomotiveOrder> findByUserId(UUID id) {
        return List.of();
    }
}
