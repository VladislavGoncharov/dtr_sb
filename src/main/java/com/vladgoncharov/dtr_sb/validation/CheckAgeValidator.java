package com.vladgoncharov.dtr_sb.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckAgeValidator implements ConstraintValidator<CheckAge, String> {

    @Override
    public boolean isValid(String checkAge, ConstraintValidatorContext constraintValidatorContext) {

        if (checkAge.isEmpty()) {
            return true;
        }

        int checkAgeInt;

        try{
           checkAgeInt = Integer.parseInt(checkAge);
        } catch (Exception e){
            return false;
        }

        return checkAgeInt >= 5 && checkAgeInt <= 100;
    }
}

