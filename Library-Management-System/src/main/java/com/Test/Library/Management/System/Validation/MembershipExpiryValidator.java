package com.Test.Library.Management.System.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MembershipExpiryValidator implements ConstraintValidator<ValidExpiryDate, Calendar>  {
    private String futureMessage;
    private String daysMessage;


    @Override
    public void initialize(ValidExpiryDate constraintAnnotation) {
        futureMessage = constraintAnnotation.futureMessage();
        daysMessage = constraintAnnotation.daysMessage();
    }

    @Override
    public boolean isValid(Calendar calendar, ConstraintValidatorContext constraintValidatorContext) {
        if (calendar == null) {
            return true;
        }

        Date now=Calendar.getInstance().getTime();
       if(calendar.before(now))
       {
           constraintValidatorContext.disableDefaultConstraintViolation();
           constraintValidatorContext.buildConstraintViolationWithTemplate(futureMessage).addConstraintViolation();
           return false;
       }
        long differenceInMillis = calendar.getTimeInMillis() - Calendar.getInstance().getTimeInMillis();
        long differenceInDays = TimeUnit.MILLISECONDS.toDays(differenceInMillis);

        if(differenceInDays>=30)
        {
            return  true;
        }
        else {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(daysMessage).addConstraintViolation();
            return false;
        }

    }
}
