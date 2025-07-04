package com.moyses.api_system_car.infraestructure.web.handler;

import com.moyses.api_system_car.infraestructure.web.dto.api.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.security.sasl.AuthenticationException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Response<Map<String, String>>> handleValidationErrors(MethodArgumentNotValidException exception){

        Map<String, String> errors = new HashMap<>();

        for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return ResponseEntity.badRequest().body(Response.error("Validation failed", errors));
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<Response<String>> handleAuthError(AuthenticationException exception) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Response.error("Invalid credentials", exception.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response<String>> handleGenericError(Exception exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Response.error("A generic exception occurred.", exception.getMessage()));
    }
}
