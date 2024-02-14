package com.iamdevnoel.course.resources.exceptions;

import com.iamdevnoel.course.services.exceptions.DatabaseException;
import com.iamdevnoel.course.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(
            ResourceNotFoundException exception, HttpServletRequest request
    ) {
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError stndError = new StandardError(
                Instant.now(), status.value(), error, exception.getMessage(), request.getRequestURI()
        );
        return ResponseEntity.status(status).body(stndError);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> database(DatabaseException exception, HttpServletRequest request) {
        String error = "Database error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError stndError = new StandardError(
                Instant.now(), status.value(), error, exception.getMessage(), request.getRequestURI()
        );
        return ResponseEntity.status(status).body(stndError);
    }
}
