package com.kavinaam.springdemo.validation;

import org.apache.commons.validator.routines.EmailValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailVerificationValidator implements ConstraintValidator<EmailVerification, String> {

    String message;

    @Override
    public void initialize(EmailVerification emailVerification) {
        message = emailVerification.message();
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {

        EmailValidator emailValidator = EmailValidator.getInstance();

        if(email == null) {
            return false;
        }

        if(!emailValidator.isValid(email)) {
            return false;
        }
        return true;
    }
}
