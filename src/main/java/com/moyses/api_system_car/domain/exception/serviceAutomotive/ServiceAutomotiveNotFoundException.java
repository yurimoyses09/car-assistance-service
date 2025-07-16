package com.moyses.api_system_car.domain.exception.serviceAutomotive;

public class ServiceAutomotiveNotFoundException extends ServiceAutomotiveException {
    public ServiceAutomotiveNotFoundException(String message) {
        super(message);
    }

    public ServiceAutomotiveNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
