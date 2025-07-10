package com.moyses.api_system_car.infraestructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_user")
public class UserEntity {
    @Id
    private UUID id;

    private String name;
    private Integer age;

    @Column(unique = true)
    private String email;
    private String password;
    private String address;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private CarEntity car;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ServiceAutomotiveOrderEntity> serviceAutomotiveOrderEntityList;
}
