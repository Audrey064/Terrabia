package org.springframework.terrabia.models.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter

public class ErrorResponse {

    private String message;
    private long timestamp;
    private int status;
}
