package com.moyses.api_system_car.application.dto.serviceOrder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceAutomotiveOrderEvent {

    public UUID id_service;
    public UUID id_user;
    public LocalDateTime scheduled_date;
}
