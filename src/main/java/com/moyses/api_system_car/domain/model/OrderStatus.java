package com.moyses.api_system_car.domain.model;

import lombok.Getter;

@Getter
public enum OrderStatus {
    PENDING("Pending"),
    IN_PROGRESS("In Progress"),
    COMPLETED("Completed"),
    CANCELED("Canceled");

    private final String description;

    OrderStatus(String description) {
        this.description = description;
    }
}