package org.springframework.terrabia.models.dtos.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import org.springframework.terrabia.models.enumerations.UserRole;

@Getter
@Setter
@RequiredArgsConstructor

public class RegisterRequest {

    @NotBlank(message = "The field shouldn't be empty, An email is required")
    @Email(message = "An email is required")
    private String email;

    @NotBlank(message = "The field shouldn't be empty, a password is required")
    @Size(min = 8, message = "The password should have at least 8 characters")
    private String password;

    @NotNull
    private UserRole role;

   // Specific attribute to Farmer and Customer

    @NotBlank(message = "The field shouldn't be empty, a is first name required")
    @Size(min = 3, message = "The password should have at least 3 characters")
    private String firstName;

    @NotBlank(message = "The field shouldn't be empty, a last name is required")
    @Size(min = 3, message = "The password should have at least 3 characters")
    private String lastName;

    @NotBlank
    @Size(min = 9, max = 9, message = "The password should have 9 characters")
    private String phoneNumber;

    @NotBlank
    private String address;

    // Specific attribute to Farmer

    @Size(min = 3, message = "The password should have at least 3 characters")
    private String domainName;

  //  private AccountRequest account;
}
