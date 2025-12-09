package org.springframework.terrabia.models.dtos.requests;

import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Getter
@RequiredArgsConstructor


public class AccountRequest {

    @NotBlank
    private UUID accountNumber;

    @NotBlank
    private float balance;
}
