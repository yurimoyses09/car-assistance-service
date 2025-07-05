package com.moyses.api_system_car.domain.model;

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
public class ServiceAutomotiveOrder {
    private UUID id;
    public String name;
    public Double price;
    public String description;
    public LocalDateTime scheduledDate;
    public LocalDateTime createAt;
    public LocalDateTime updateAt;
    private User user;
    private Car car;
}
