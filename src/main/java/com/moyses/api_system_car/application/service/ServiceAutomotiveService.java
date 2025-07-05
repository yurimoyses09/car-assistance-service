package com.moyses.api_system_car.application.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.moyses.api_system_car.domain.model.ServiceAutomotiveOrder;
import com.moyses.api_system_car.domain.repository.ICarRepository;
import com.moyses.api_system_car.domain.repository.IServiceAutomotiveRepository;
import com.moyses.api_system_car.domain.repository.IUserRepository;
import com.moyses.api_system_car.infraestructure.persistence.mapper.CarMapper;
import com.moyses.api_system_car.infraestructure.persistence.mapper.ServiceAutomotiveOrderMapper;
import com.moyses.api_system_car.infraestructure.web.dto.serviceOrder.ServiceAutomotiveOrderRequest;
import com.moyses.api_system_car.infraestructure.web.dto.serviceOrder.ServiceAutomotiveOrderResponse;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceAutomotiveService {

    private final IServiceAutomotiveRepository _repository;
    private final IUserRepository _userRepository;
    private final ICarRepository _carRepository;
    private final ServiceAutomotiveOrderMapper _mapper;
    private final CarMapper _carMapper;

    public ServiceAutomotiveService(IServiceAutomotiveRepository repository, IUserRepository userRepository, ICarRepository carRepository, ServiceAutomotiveOrderMapper mapper, CarMapper carMapper) {
        _repository = repository;
        _userRepository = userRepository;
        _carRepository = carRepository;
        _mapper = mapper;
        _carMapper = carMapper;
    }

    public ServiceAutomotiveOrder createOrder(ServiceAutomotiveOrderRequest request, UserDetails userDetails) throws IOException {
        var user = _userRepository.findByEmail(userDetails.getUsername());
        var car  = _carRepository.getCarByIdUser(user.get().getId());
        car.setUser(user.get());

        var service = getServiceById(request.getId_service());

        var model = _mapper.toModel(car, user.get(), request, service.get());

        return _repository.createOrder(model);
    }

    public List<ServiceAutomotiveOrderResponse> getListServices() throws IOException {
        var resource = new ClassPathResource("catalog/db.json");
        ObjectMapper mapper = new ObjectMapper();

        mapper.registerModule(new com.fasterxml.jackson.datatype.jsr310.JavaTimeModule());

        var node = mapper.readTree(resource.getInputStream());

        return mapper.convertValue(
                node.get("services"),
                new TypeReference<List<ServiceAutomotiveOrderResponse>>() {}
        );
    }

    public Optional<ServiceAutomotiveOrderResponse> getServiceById(Integer id) throws IOException {
        return getListServices().stream().filter(x -> x.getId().equals(id)).findFirst();
    }
}
