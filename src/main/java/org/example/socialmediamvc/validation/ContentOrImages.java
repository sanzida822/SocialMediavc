package org.example.socialmediamvc.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.example.socialmediamvc.utils.Constants;

import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ContentOrImagesValidator.class)
public @interface ContentOrImages {
    String message() default Constants.ErrorMessage.POST_CONTENT_OR_IMAGE_REQUIRED;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};


}
