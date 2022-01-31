package com.vladgoncharov.dtr_sb.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckNameValidator implements ConstraintValidator<CheckName, String> {


    private int space = 0;

    @Override
    public boolean isValid(String checkName, ConstraintValidatorContext constraintValidatorContext) {

        if (checkName == null) return true;

        for (int i = 0; i < checkName.length(); i++) {
            char symbol = checkName.charAt(i);

            if (space > 2) {
                return false;
            }

            if (Character.isSpaceChar(symbol)) {
                space++;
                continue;
            }

            if (!Character.isLetter(symbol)) {
                return false;
            }
        }
        return true;
    }
}
