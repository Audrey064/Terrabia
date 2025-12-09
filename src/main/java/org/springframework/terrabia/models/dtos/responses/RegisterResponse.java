package org.springframework.terrabia.models.dtos.responses;

import lombok.Builder;
import org.springframework.terrabia.models.metier.User;

@Builder

public class RegisterResponse {

    private String token;
    private User user;

}
