package com.moyses.api_system_car.application.dto.car;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarResponse {

    private UUID id;
    private String model;
    private Integer year;
    private String plate;
}
