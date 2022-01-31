package com.vladgoncharov.dtr_sb.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckAgeValidator implements ConstraintValidator<CheckAge, Integer> {

    @Override
    public boolean isValid(Integer checkAge, ConstraintValidatorContext constraintValidatorContext) {

        if (checkAge == 0) return true;

        return checkAge >= 5 && checkAge <= 100;
    }
}

