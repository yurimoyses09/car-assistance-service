package com.moyses.api_system_car.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private UUID id;
    private String name;
    private Integer age;
    private String email;
    private String password;
    private String address;
    private Car car;
    private List<ServiceOrder> serviceOrderList;
}
