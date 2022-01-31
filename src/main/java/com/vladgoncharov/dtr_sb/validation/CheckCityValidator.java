package com.vladgoncharov.dtr_sb.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckCityValidator implements ConstraintValidator<CheckCity, String> {

    private int spaceOrDash = 0;

    @Override
    public boolean isValid(String checkCity, ConstraintValidatorContext constraintValidatorContext) {

        if (checkCity==null)return true;

        for (int i = 0; i < checkCity.length(); i++) {
            Character symbol = checkCity.charAt(i);

            if (spaceOrDash>2) {
                return false;
            }

            if (Character.isSpaceChar(symbol) || symbol.equals('-')) {
                spaceOrDash++;
                continue;
            }

            if (!Character.isLetter(symbol)){
                return false;}
        }
        return true;
    }
}

