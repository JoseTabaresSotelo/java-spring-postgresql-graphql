package com.ti.blog;

import java.util.Arrays;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ti.blog.exception.ErrorResponse;
import com.ti.blog.exception.UserNotEnrolledException;
import com.ti.blog.exception.UserNotFoundException;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ UserNotFoundException.class, UserNotEnrolledException.class })
    public ResponseEntity<Object> handleResourceNotFoundException(RuntimeException ex) {
        ErrorResponse error = new ErrorResponse(Arrays.asList(ex.getMessage()));
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<Object> handleDataAccessException(EmptyResultDataAccessException ex) {
        ErrorResponse error = new ErrorResponse(Arrays.asList("Cannot delete non-existing resource"));
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        ErrorResponse error = new ErrorResponse(
                Arrays.asList("Data Integrity Violation: we cannot process your request."));
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
