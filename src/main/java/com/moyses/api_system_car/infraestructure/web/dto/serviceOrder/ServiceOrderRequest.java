package com.moyses.api_system_car.infraestructure.web.dto.serviceOrder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceOrderRequest {

    public String name;
    public Double price;
    public String description;
    public String status;
    public Date scheduledDate;
}
