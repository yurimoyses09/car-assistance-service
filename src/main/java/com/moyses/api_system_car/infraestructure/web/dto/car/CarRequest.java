package com.moyses.api_system_car.infraestructure.web.dto.car;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarRequest {

    @NotBlank(message = "The car model is necessary.")
    private String model;

    @NotBlank(message = "The year of the car is necessary.")
    private Integer year;

    @NotBlank(message = "The car license plate is necessary.")
    private String plate;
}
