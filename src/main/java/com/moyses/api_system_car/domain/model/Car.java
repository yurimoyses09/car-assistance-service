package com.moyses.api_system_car.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    private UUID id;
    private String model;
    private Integer year;
    private String plate;
    private User user;
    private List<ServiceOrder> serviceOrderList;
}