package com.vladgoncharov.dtr_sb.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckEmailValidator.class)
public @interface CheckEmail {

    String message() default "Не верно, попробуйте еще раз";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
