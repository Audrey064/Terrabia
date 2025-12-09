package org.springframework.terrabia.exceptions;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.terrabia.models.dtos.responses.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice

public class GlobalExceptionHandler{

    @ExceptionHandler(ResourceAlreadyExistsException.class)

    public ResponseEntity<ErrorResponse> handleConflict(ResourceAlreadyExistsException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new
                        ErrorResponse(
                                ex.getMessage(),
                        System.currentTimeMillis(),
                        409
                ));
    }


    @ExceptionHandler(ResourceNotFoundException.class)

    public ResponseEntity<ErrorResponse> handleNotFound(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new
                        ErrorResponse(
                                ex.getMessage(),
                        System.currentTimeMillis(),
                            404
                ));
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleBusinessException (BusinessException ex) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(new
                        ErrorResponse(
                        ex.getMessage(),
                        System.currentTimeMillis(),
                        HttpStatus.UNPROCESSABLE_ENTITY.value()
                ));
    }


    @ExceptionHandler(BusinessValidation.class)
    public ResponseEntity<ErrorResponse> handleFieldValidation(BusinessValidation ex) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(new
                        ErrorResponse(
                        ex.getMessage(),
                        System.currentTimeMillis(),
                        HttpStatus.UNPROCESSABLE_ENTITY.value()
                ));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneric(Exception ex) {
        ErrorResponse error = new ErrorResponse(
                "Unexpected error: " + ex.getMessage(),
                System.currentTimeMillis(),
                HttpStatus.INTERNAL_SERVER_ERROR.value()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}
