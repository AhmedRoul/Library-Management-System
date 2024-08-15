package com.Test.Library.Management.System.Validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = MembershipExpiryValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidExpiryDate {
    String message() default "Invalid expiry date";

    String futureMessage() default "Expiry date must be in the future";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String daysMessage() default "Invalid date . The date must be at least 30 days from now ";
}
