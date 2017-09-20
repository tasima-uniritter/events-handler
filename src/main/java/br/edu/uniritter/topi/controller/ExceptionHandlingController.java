package br.edu.uniritter.topi.controller;

import br.edu.uniritter.topi.dto.ApiError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionHandlingController {
    private ApiError parseErrors(List<ObjectError> errors, HttpStatus status, String message) {
        List<String> parsedErrors = new ArrayList<String>();

        for (ObjectError error : errors) {
            String name = error instanceof FieldError ? ((FieldError) error).getField() : error.getObjectName();
            parsedErrors.add(name + ": " + error.getDefaultMessage());
        }

        return new ApiError(HttpStatus.BAD_REQUEST, "Validation error", parsedErrors);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public @ResponseBody ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        ApiError apiError = parseErrors(ex.getBindingResult().getAllErrors(), HttpStatus.BAD_REQUEST, "Validation Error");

        return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
    }
}
