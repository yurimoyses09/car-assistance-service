package com.moyses.api_system_car.infraestructure.web.dto.serviceOrder;

import java.util.Date;
import java.util.UUID;

public class ServiceOrderResponse {

    private UUID id;
    public String type;
    public String description;
    public Date scheduledDate;

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

    public ServiceOrderResponse(UUID id, String type, String description, Date scheduledDate) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.scheduledDate = scheduledDate;
    }
}
