package com.moyses.api_system_car.domain.model;

import java.util.Date;
import java.util.UUID;

public class ServiceOrder {

    private UUID id;

    public String type;
    public String description;
    public Date scheduledDate;
    private User user;
    private Car car;

    public ServiceOrder(UUID id, String type, String description, Date scheduledDate, User user, Car car) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.scheduledDate = scheduledDate;
        this.user = user;
        this.car = car;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(Date scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
