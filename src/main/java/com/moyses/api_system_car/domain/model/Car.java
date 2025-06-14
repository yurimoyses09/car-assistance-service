package com.moyses.api_system_car.domain.model;

import java.util.List;
import java.util.UUID;

public class Car {

    private UUID id;
    private String model;
    private Integer year;
    private String plate;
    private User user;
    private List<ServiceOrder> serviceOrderList;

    public Car(UUID id, String model, Integer year, String plate, User user, List<ServiceOrder> serviceOrderList) {
        this.id = id;
        this.model = model;
        this.year = year;
        this.plate = plate;
        this.user = user;
        this.serviceOrderList = serviceOrderList;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ServiceOrder> getServiceOrderList() {
        return serviceOrderList;
    }

    public void setServiceOrderList(List<ServiceOrder> serviceOrderList) {
        this.serviceOrderList = serviceOrderList;
    }
}