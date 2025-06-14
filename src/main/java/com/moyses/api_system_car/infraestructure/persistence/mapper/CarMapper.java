package com.moyses.api_system_car.infraestructure.persistence.mapper;

import com.moyses.api_system_car.infraestructure.persistence.entity.CarEntity;
import com.moyses.api_system_car.infraestructure.web.dto.car.CarRequest;
import com.moyses.api_system_car.infraestructure.web.dto.car.CarResponse;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {

    public CarEntity toEntity(CarRequest request){
        var r = new CarEntity();

        r.setModel(request.getModel());
        r.setPlate(request.getPlate());
        r.setYear(request.getYear());

        return r;
    }

    public CarResponse ToResponse(CarEntity carEntity){
        return new CarResponse(carEntity.getId(), carEntity.getModel(), carEntity.getYear(), carEntity.getPlate());
    }
}
