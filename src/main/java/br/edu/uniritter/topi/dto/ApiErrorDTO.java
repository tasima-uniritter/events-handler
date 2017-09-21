package br.edu.uniritter.topi.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

@Data
public class ApiErrorDTO {
    private HttpStatus status;
    private String message;
    private List<String> errors;

    public ApiErrorDTO(HttpStatus status, String message, List<String> errors) {
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public ApiErrorDTO(HttpStatus status, String message, String error) {
        this.status = status;
        this.message = message;
        errors = Arrays.asList(error);
    }
}
