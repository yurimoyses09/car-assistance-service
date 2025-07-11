package com.moyses.api_system_car.infraestructure.web.dto.serviceOrder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceAutomotiveOrderRequest {

    public UUID id_service;
    public LocalDateTime scheduled_date;
}