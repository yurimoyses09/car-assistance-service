package com.moyses.api_system_car.application.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    @Email
    @NotBlank(message = "An email is required to register in the system.")
    private String email;

    @NotBlank(message = "It is necessary to have a password to register in the system.")
    private String password;

    private String name;
    private Integer age;
    private String address;
}
