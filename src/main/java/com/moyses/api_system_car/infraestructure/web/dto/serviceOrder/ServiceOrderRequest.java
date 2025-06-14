package com.moyses.api_system_car.infraestructure.web.dto.serviceOrder;

import java.util.Date;

public class ServiceOrderRequest {

    public String type;
    public String description;
    public String status = "Pendent";
    public Date scheduledDate;

    public ServiceOrderRequest(String type, String description, String status, Date scheduledDate) {
        this.type = type;
        this.description = description;
        this.status = status;
        this.scheduledDate = scheduledDate;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(Date scheduledDate) {
        this.scheduledDate = scheduledDate;
    }
}
