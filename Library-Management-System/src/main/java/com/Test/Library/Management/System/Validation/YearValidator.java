package com.Test.Library.Management.System.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.Year;

public class YearValidator implements ConstraintValidator<ValidYear, Short> {
    @Override
    public void initialize(ValidYear constraintAnnotation) {

    }

    @Override
    public boolean isValid(Short aShort, ConstraintValidatorContext constraintValidatorContext) {
        if (aShort == null) {
            return false;
        }
        return aShort <= Year.now().getValue();

    }
}
