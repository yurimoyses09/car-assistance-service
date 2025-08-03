package com.moyses.api_system_car.domain.exception.serviceAutomotive;

public class ServiceAutomotiveException extends RuntimeException {
    public ServiceAutomotiveException(String message) {
        super(message);
    }

    public ServiceAutomotiveException(String message, Throwable cause) {
        super(message, cause);
    }

}
