package org.example.socialmediamvc.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ImageFileValidator.class)
public @interface ImageFile {
    String message() default "Invalid image file type. Only JPG is allowed.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
