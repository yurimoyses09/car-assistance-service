package com.moyses.api_system_car.domain.model;

import java.util.UUID;

public class Car {

    private UUID id;
    private String model;
    private Integer year;
    private String plate;
    private UUID idUser;

    public Car(UUID id, String model, Integer year, String plate, UUID idUser) {
        this.id = id;
        this.model = model;
        this.year = year;
        this.plate = plate;
        this.idUser = idUser;
    }

    public UUID getIdUser() {
        return idUser;
    }

    public void setIdUser(UUID idUser) {
        this.idUser = idUser;
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
}