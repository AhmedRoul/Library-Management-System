package com.Test.Library.Management.System.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class ISBNValidator implements ConstraintValidator<ValidISBN,String> {
    @Override
    public void initialize(ValidISBN constraintAnnotation)
    {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s==null||s.length()<13)
            return false;

        else  if(s.length()>17)
            return false;
        else{
            boolean match = Pattern.compile("[0-9-]*").matcher(s).matches(); // include - or number only
            if(match){
                String numbers=s.replace("-","");
                return numbers.length() == 13;
            }
            else
                return false;
        }
    }
}
