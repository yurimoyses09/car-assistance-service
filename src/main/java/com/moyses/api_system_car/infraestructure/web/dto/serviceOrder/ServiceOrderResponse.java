package com.moyses.api_system_car.infraestructure.web.dto.serviceOrder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceOrderResponse {

    private Integer id;
    public String name;
    public String description;
    public BigDecimal price;
    public List<LocalDateTime> available_data;
}
