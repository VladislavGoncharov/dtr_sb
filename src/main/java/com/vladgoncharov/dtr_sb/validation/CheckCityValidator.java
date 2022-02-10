package com.vladgoncharov.dtr_sb.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckCityValidator implements ConstraintValidator<CheckCity, String> {

    private int spaceOrDash = 0;

    @Override
    public boolean isValid(String checkCity, ConstraintValidatorContext constraintValidatorContext) {

        if (checkCity.isEmpty()) {
            return true;
        }

        for (int i = 0; i < checkCity.length(); i++) {
            Character symbol = checkCity.charAt(i);

            //более 2 пробелов/тире/пробелов-тире быть не может
            if (spaceOrDash>2) {
                spaceOrDash = 0;
                return false;
            }

            if (Character.isSpaceChar(symbol) || symbol.equals('-')) {
                spaceOrDash++;
                continue;
            }

            if (!Character.isLetter(symbol)){
                spaceOrDash = 0;
                return false;}
        }

        spaceOrDash = 0;
        return true;
    }
}

