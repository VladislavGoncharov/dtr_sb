package com.vladgoncharov.dtr_sb.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckPasswordValidator implements ConstraintValidator<CheckPassword, String> {

    private String passwordCheck;

    @Override
    public void initialize(CheckPassword constraintAnnotation) {
        passwordCheck = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {

        if (password.equals(passwordCheck)) {
            return true;
        } else return false;
    }
}
