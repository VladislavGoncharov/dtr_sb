package com.vladgoncharov.dtr_sb.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckAgeValidator.class)
public @interface CheckAge {

    String message() default "Сомневаюсь, что это ваш возраст";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
