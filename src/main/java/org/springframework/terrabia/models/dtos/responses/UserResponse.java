package org.springframework.terrabia.models.dtos.responses;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.terrabia.models.enumerations.UserRole;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor


public class UserResponse {

    private UUID id;
    private String email;
    private UserRole role;
    private AccountDto accountDto;
}
