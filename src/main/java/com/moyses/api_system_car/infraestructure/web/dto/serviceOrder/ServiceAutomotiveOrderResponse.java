package com.moyses.api_system_car.infraestructure.web.dto.serviceOrder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceAutomotiveOrderResponse {

    private UUID id;
    private String name;
    private String description;
    private Double price;
    private List<LocalDateTime> available_data;
}
