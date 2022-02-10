package com.vladgoncharov.dtr_sb.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckNameValidator implements ConstraintValidator<CheckName, String> {

    private int space = 0;

    @Override
    public boolean isValid(String checkName, ConstraintValidatorContext constraintValidatorContext) {

        if (checkName.isEmpty()) {
            return true;
        }

        for (int i = 0; i < checkName.length(); i++) {
            char symbol = checkName.charAt(i);

            if (space > 2) {
                space = 0;
                return false;
            }

            if (Character.isSpaceChar(symbol)) {
                space++;
                continue;
            }

            if (!Character.isLetter(symbol)) {
                space = 0;
                return false;
            }
        }

        space = 0;
        return true;
    }
}
