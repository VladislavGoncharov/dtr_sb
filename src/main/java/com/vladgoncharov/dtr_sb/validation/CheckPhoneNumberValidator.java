package com.vladgoncharov.dtr_sb.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckPhoneNumberValidator implements ConstraintValidator<CheckPhoneNumber, String> {

    @Override
    public boolean isValid(String checkPhoneNumber, ConstraintValidatorContext constraintValidatorContext) {

        if (checkPhoneNumber.isEmpty()) {
            return true;
        }

        if (checkPhoneNumber.startsWith("+7") && checkPhoneNumber.length()==12){
            checkPhoneNumber=checkPhoneNumber.substring(2);
            for (int i = 0; i < checkPhoneNumber.length(); i++) {
                if ( !Character.isDigit(checkPhoneNumber.charAt(i)) )return false;
            }
        }else if (checkPhoneNumber.startsWith("8") && checkPhoneNumber.length()==11){
            for (int i = 0; i < checkPhoneNumber.length(); i++) {
                if ( !Character.isDigit(checkPhoneNumber.charAt(i)) )return false;
            }
        }else return false;

        return true;
    }
}

