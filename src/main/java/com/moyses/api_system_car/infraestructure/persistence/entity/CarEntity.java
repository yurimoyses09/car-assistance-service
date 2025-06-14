package com.moyses.api_system_car.infraestructure.persistence.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
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

    public CarEntity(){}

    public CarEntity(UUID id, String model, Integer year, String plate, UserEntity user) {
        this.id = id;
        this.model = model;
        this.year = year;
        this.plate = plate;
        this.user = user;
    }

    public CarEntity(UserEntity user, String plate, Integer year, String model) {
        this.user = user;
        this.plate = plate;
        this.year = year;
        this.model = model;
        this.setId(UUID.randomUUID());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
