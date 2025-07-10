package com.moyses.api_system_car.domain.repository;

import com.moyses.api_system_car.domain.model.ServiceAutomotiveOrder;

import java.util.List;
import java.util.UUID;

public interface IServiceAutomotiveRepository {
    ServiceAutomotiveOrder createOrder(ServiceAutomotiveOrder entity);
    List<ServiceAutomotiveOrder> findByUserId(UUID id);
}
