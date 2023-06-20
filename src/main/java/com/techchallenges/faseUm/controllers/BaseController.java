package com.techchallenges.faseUm.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.techchallenges.faseUm.dtos.ErrorDTO;
import com.techchallenges.faseUm.dtos.ValidationErrorDTO;

@RestControllerAdvice
public class BaseController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ValidationErrorDTO handleValidationErrors(MethodArgumentNotValidException exception) {
        List<String> validationErrors = parseValidationErrorsToListString(exception);
        return new ValidationErrorDTO(validationErrors, "Houve erro(s) de validação", exception.getDetailMessageCode());
    }

    private List<String> parseValidationErrorsToListString(MethodArgumentNotValidException exception) {
        return exception.getBindingResult().getAllErrors().stream()
                .map(e -> String.format("%s: %s", ((FieldError) e).getField(), e.getDefaultMessage())).toList();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public ErrorDTO handleExceptions(Exception exception) {
        return new ErrorDTO(exception.getMessage(), exception.toString());
    }

}
