package com.example.javaassignment.web.exceptions;


import com.example.javaassignment.web.dto.response.ApplicationExceptionResponseDto;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApplicationExceptionResponseDto> handleException(MethodArgumentNotValidException exception) {
        return new ResponseEntity<>(ApplicationExceptionResponseDto.builder()
                .message("Input validation error")
                .status(422)
                .errors(generateErrorMessages(exception))
                .build(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    private Map<String, String> generateErrorMessages(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError fieldError : e.getFieldErrors()) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        for (ObjectError objectError : e.getGlobalErrors()) {
            errors.put(objectError.getObjectName(), objectError.getDefaultMessage());
        }
        return errors;
    }
}
