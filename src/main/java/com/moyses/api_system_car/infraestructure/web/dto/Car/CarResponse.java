package com.moyses.api_system_car.infraestructure.web.dto.Car;

import java.util.UUID;

public class CarResponse {

    private UUID id;
    private String model;
    private Integer year;
    private String plate;

    public CarResponse(UUID id, String model, Integer year, String plate) {
        this.id = id;
        this.model = model;
        this.year = year;
        this.plate = plate;
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
