package org.springframework.terrabia.models.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class AccountDto {
    private UUID id;
    private UUID accountNumber;
    private float balance;
}
