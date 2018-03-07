package com.kavinaam.crm.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = EmailVerificationValidator.class)
public @interface EmailVerification {

    // message attribute
    String message() default "* Email is not valid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
