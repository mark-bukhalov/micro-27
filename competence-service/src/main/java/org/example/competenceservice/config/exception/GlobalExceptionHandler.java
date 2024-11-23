package org.example.competenceservice.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ControllerAdvice
public class GlobalExceptionHandler {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleAllExceptions(Exception ex) {
        return createErrorResponseEntity(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResponseStatusException ex) {
        return createErrorResponseEntity(ex, HttpStatus.valueOf(ex.getStatusCode().value()));
    }

    private ResponseEntity<ErrorResponse> createErrorResponseEntity(Exception ex, HttpStatus status) {
        ErrorResponse errorResponse = createDefaultErrorResponse(ex, status.value());
        return new ResponseEntity<>(errorResponse, status);
    }

    private ErrorResponse createDefaultErrorResponse(Exception ex, int status) {
        return new ErrorResponse(
                status,
                ex.getMessage(),
                LocalDateTime.now().format(formatter)
        );
    }
}


