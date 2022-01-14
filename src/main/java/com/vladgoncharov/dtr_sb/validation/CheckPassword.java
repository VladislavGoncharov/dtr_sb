package com.vladgoncharov.dtr_sb.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Size;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckPasswordValidator.class)
public @interface CheckPassword {

    String value();

    String message() default "пароли не совпадают";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
