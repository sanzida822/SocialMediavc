package org.example.socialmediamvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.socialmediamvc.dto.ImageRequestDto;
import org.example.socialmediamvc.utils.Constants;
import org.springframework.web.multipart.MultipartFile;

public class AllowedImageTypeValidator implements ConstraintValidator<AllowedImageType, MultipartFile> {
    public boolean isValid(MultipartFile file, ConstraintValidatorContext context) {
        if(file == null || file.isEmpty()){
            return true;
        }
        String contentType = file.getContentType();
        if(contentType == null || !Constants.Media.ALLOWED_IMAGE_TYPES.contains(contentType)){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(Constants.ErrorMessage.INVALID_IMAGE_TYPE).addConstraintViolation();

       return false; }
    return true;
    }
}
