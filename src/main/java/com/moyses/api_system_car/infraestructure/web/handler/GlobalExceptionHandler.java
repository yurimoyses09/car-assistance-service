package com.moyses.api_system_car.infraestructure.web.handler;

import com.moyses.api_system_car.domain.exception.CatalogLoadException;
import com.moyses.api_system_car.domain.exception.serviceAutomotive.ServiceAutomotiveException;
import com.moyses.api_system_car.domain.exception.serviceAutomotive.ServiceAutomotiveNotFoundException;
import com.moyses.api_system_car.infraestructure.web.dto.api.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.security.sasl.AuthenticationException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //region Handle Service Automotive
    @ExceptionHandler(ServiceAutomotiveNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleServiceAutomotiveExceptionNotFound(ServiceAutomotiveNotFoundException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("Service Not Found", ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(ServiceAutomotiveException.class)
    public ResponseEntity<Map<String, String>> handleServiceAutomotiveExceptionBadRequest(ServiceAutomotiveException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("Error", ex.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
    //endregion

    //region Handle Generic
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response<String>> handleException(Exception exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Response.error("A generic Exception occurred.", exception.getMessage()));
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<Response<String>> handleIOException(IOException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Response.error("A generic IOException occurred.", exception.getMessage()));
    }
    //endregion

    //region Handle Validation
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Response<Map<String, String>>> handleArgumentNotValidException(MethodArgumentNotValidException exception){

        Map<String, String> errors = new HashMap<>();

        for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return ResponseEntity.badRequest().body(Response.error("Validation failed", errors));
    }
    //endregion

    //region Handle Authentication Invalid Credentials
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<Response<String>> handleAAuthenticationException(AuthenticationException exception) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Response.error("Invalid Credentials", exception.getMessage()));
    }
    //endregion

    //region Handle CatalogLoad
    @ExceptionHandler(CatalogLoadException.class)
    public ResponseEntity<Response<String>> handleCatalogLoadException(CatalogLoadException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Response.error("Error loading automotive service catalog.", ex.getMessage()));
    }
    //endregion
}
