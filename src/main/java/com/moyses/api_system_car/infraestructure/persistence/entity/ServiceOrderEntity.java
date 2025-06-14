package com.moyses.api_system_car.infraestructure.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "tb_service_order")
public class ServiceOrderEntity {
    @Id
    private UUID id;

    public String type;
    public String description;
    public Date scheduledDate;

    private LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private CarEntity car;

    public ServiceOrderEntity(){}

    public ServiceOrderEntity(UUID id, String type, String description, Date scheduledDate, LocalDateTime createdAt, UserEntity user, CarEntity car) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.scheduledDate = scheduledDate;
        this.createdAt = createdAt;
        this.user = user;
        this.car = car;
    }

    public ServiceOrderEntity(String type, String description, Date scheduledDate) {
        this.type = type;
        this.description = description;
        this.scheduledDate = scheduledDate;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public CarEntity getCar() {
        return car;
    }

    public void setCar(CarEntity car) {
        this.car = car;
    }
}
