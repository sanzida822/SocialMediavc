package org.example.socialmediamvc.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.example.socialmediamvc.utils.Constants;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueEmailValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface  UniqueEmail {
    String message() default Constants.ErrorMessage.EMAIL_ALREADY_REGISTERED;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
