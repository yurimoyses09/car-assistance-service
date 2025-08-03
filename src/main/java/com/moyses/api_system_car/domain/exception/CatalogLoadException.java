package com.moyses.api_system_car.domain.exception;

public class CatalogLoadException extends RuntimeException{
    public CatalogLoadException(String message) {
        super(message);
    }

    public CatalogLoadException(String message, Throwable cause) {
        super(message, cause);
    }
}
