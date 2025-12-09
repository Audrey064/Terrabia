package org.springframework.terrabia.exceptions;

public class BusinessValidation extends RuntimeException {
    public BusinessValidation(String message) {
        super(message);
    }
}
