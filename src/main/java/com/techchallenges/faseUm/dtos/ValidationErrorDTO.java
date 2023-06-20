package com.techchallenges.faseUm.dtos;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidationErrorDTO extends ErrorDTO {
    private List<String> validationErrors;

    public ValidationErrorDTO(List<String> validationErrors, String errorMessage, String exception) {
        super(errorMessage, exception);
        this.validationErrors = validationErrors;
    }
}
