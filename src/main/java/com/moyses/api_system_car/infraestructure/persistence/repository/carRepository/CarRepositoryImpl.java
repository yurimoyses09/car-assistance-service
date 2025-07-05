package com.moyses.api_system_car.infraestructure.persistence.repository.carRepository;

import com.moyses.api_system_car.domain.model.Car;
import com.moyses.api_system_car.domain.repository.ICarRepository;
import com.moyses.api_system_car.infraestructure.persistence.mapper.CarMapper;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class CarRepositoryImpl implements ICarRepository {

    private final ICarJpaRepository _carJpaRepository;
    private final CarMapper _mapper;

    public CarRepositoryImpl(ICarJpaRepository carJpaRepository, CarMapper mapper) {
        _carJpaRepository = carJpaRepository;
        _mapper = mapper;
    }

    @Override
    public Car registerCar(Car car) {
        var carEntity = _mapper.toEntity(car);
        var savedEntity = _carJpaRepository.save(carEntity);

        return _mapper.toModel(savedEntity);
    }

    @Override
    public Car getCarByIdUser(UUID idUser) {
        return _mapper.toModel(_carJpaRepository.getCarsByUserId(idUser));
    }
}
