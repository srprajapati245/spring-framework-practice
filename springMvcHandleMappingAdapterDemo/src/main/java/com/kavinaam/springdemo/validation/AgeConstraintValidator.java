package com.kavinaam.springdemo.validation;

import com.sun.deploy.association.utility.AppConstants;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeConstraintValidator implements ConstraintValidator<AgeConstraint, Integer> {

    private int lower;
    private int upper;

    @Override
    public void initialize(AgeConstraint ageConstraint) {
        lower = ageConstraint.lower();
        upper = ageConstraint.upper();
    }

    @Override
    public boolean isValid(Integer age, ConstraintValidatorContext context) {
        if(age == null)
            return false;
        if(age < lower || age > upper)
            return false;
        return true;
    }
}
