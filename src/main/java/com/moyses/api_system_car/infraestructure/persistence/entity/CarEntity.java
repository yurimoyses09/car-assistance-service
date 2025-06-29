package com.moyses.api_system_car.infraestructure.persistence.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_car")
public class CarEntity {

    @Id
    private UUID id;
    private String model;
    private Integer year;

    @Column(unique = true)
    private String plate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private UserEntity user;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ServiceOrderEntity> serviceOrders;
}
