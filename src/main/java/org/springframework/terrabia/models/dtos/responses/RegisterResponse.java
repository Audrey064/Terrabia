package org.springframework.terrabia.models.dtos.responses;

import lombok.*;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class RegisterResponse {

    private String token;
    private UserResponse userResponse;

}
