package com.moyses.api_system_car.domain.exception.serviceAutomotive;

public class ServiceAutomotiveBadRequestException extends ServiceAutomotiveException{
    public ServiceAutomotiveBadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceAutomotiveBadRequestException(String message) {
        super(message);
    }
}
