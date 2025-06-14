package com.moyses.api_system_car.infraestructure.web.dto.car;

public class CarRequest {
    private String model;
    private Integer year;
    private String plate;

    public CarRequest(Integer year, String plate, String model) {
        this.year = year;
        this.plate = plate;
        this.model = model;
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
