package org.example.socialmediamvc.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.example.socialmediamvc.utils.Constants;

import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AllowedImageTypeValidator.class)
public @interface AllowedImageType {
    String message() default Constants.ErrorMessage.INVALID_IMAGE_TYPE;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
