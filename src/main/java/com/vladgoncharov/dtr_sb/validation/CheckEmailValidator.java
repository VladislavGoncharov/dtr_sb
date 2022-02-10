package com.vladgoncharov.dtr_sb.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckEmailValidator implements ConstraintValidator<CheckEmail, String> {

    private final String[] forbiddenCharacters = {"\"", "(", ")", ",", ":", ";", "<", ">", "@", "[", "\\", "]", " "};

    @Override
    public boolean isValid(String checkEmail, ConstraintValidatorContext constraintValidatorContext) {

        if (checkEmail.isEmpty()){
            return true;
        }

        checkEmail = checkEmail.trim();

        if (    checkEmail.contains("..") ||
                checkEmail.contains("--") ||
                !checkEmail.contains("@"))
        {
            return false;
        }

        String[] twoPartsOfEmail = checkEmail.split("@");

        if (    twoPartsOfEmail.length > 2 ||
                twoPartsOfEmail[0].isEmpty() ||
                twoPartsOfEmail[1].isEmpty())
        {
            return false;
        }

        for (String forbiddenCharacter : forbiddenCharacters) {
            if (twoPartsOfEmail[0].contains(forbiddenCharacter)) {
                return false;
            }
        }

        if (    twoPartsOfEmail[0].startsWith(".") || twoPartsOfEmail[0].endsWith(".") ||
                twoPartsOfEmail[1].startsWith(".") || twoPartsOfEmail[1].endsWith(".") ||
                twoPartsOfEmail[1].startsWith("-") || twoPartsOfEmail[1].endsWith("-") ||
                !twoPartsOfEmail[1].contains("."))
        {
            return false;
        }

        for (int i = 0; i < twoPartsOfEmail[1].length(); i++) {
            Character symbol = twoPartsOfEmail[1].charAt(i);
            if (!Character.isLetterOrDigit(symbol)) {

                if (symbol.equals('-') || symbol.equals('.')) {

                }
                else return false;
            }
        }
        return true;
    }
}

