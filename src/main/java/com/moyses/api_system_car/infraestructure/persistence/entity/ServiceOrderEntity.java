package com.moyses.api_system_car.infraestructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tb_service_order")
public class ServiceOrderEntity {
    @Id
    private UUID id;

    public String name;
    public String description;
    public Double price;
    public Date scheduledDate;

    private LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private CarEntity car;
}
