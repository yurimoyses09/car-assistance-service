package com.moyses.api_system_car.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceOrder {

    private UUID id;

    public String type;
    public String description;
    public Date scheduledDate;
    private User user;
    private Car car;
}
