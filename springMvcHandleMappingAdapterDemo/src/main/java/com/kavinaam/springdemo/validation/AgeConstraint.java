package com.kavinaam.springdemo.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = AgeConstraintValidator.class)
public @interface AgeConstraint {

    // message attribute
    String message() default "* Age must be between 18 to 60 years";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    // lower attribute
    int lower() default 18;

    // upper attribute
    int upper() default 60;
}
