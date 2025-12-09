package org.springframework.terrabia.models.dtos.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginRequest(

        @NotBlank(message = "An email is required")
        @Email(message = "The entry must be a valid email")
        String email,

        @NotBlank(message = "A password is required")
        String password
) {
}
