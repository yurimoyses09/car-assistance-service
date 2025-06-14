package com.moyses.api_system_car.infraestructure.persistence.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
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
    private List<ServiceOrderEntity> serviceOrderEntityList;

    public UserEntity(){}

    public UserEntity(UUID id, String name, Integer age, String email, String password, String address, CarEntity car, List<ServiceOrderEntity> serviceOrderEntityList) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;
        this.address = address;
        this.car = car;
        this.serviceOrderEntityList = serviceOrderEntityList;
    }

    public UserEntity(String name, Integer age, String email, String password, String address, CarEntity car, List<ServiceOrderEntity> serviceOrderEntityList) {
        this.setId(UUID.randomUUID());
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    public UserEntity(String name, Integer age, String email, String password, String address) {
        this.setId(UUID.randomUUID());
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CarEntity getCar() {
        return car;
    }

    public void setCar(CarEntity car) {
        this.car = car;
    }

    public List<ServiceOrderEntity> getServiceOrderEntityList() {
        return serviceOrderEntityList;
    }

    public void setServiceOrderEntityList(List<ServiceOrderEntity> serviceOrderEntityList) {
        this.serviceOrderEntityList = serviceOrderEntityList;
    }
}
