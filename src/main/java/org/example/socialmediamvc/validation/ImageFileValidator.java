package org.example.socialmediamvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.socialmediamvc.utils.MessageUtil;
import org.springframework.web.multipart.MultipartFile;

public class ImageFileValidator implements ConstraintValidator<ImageFile, MultipartFile> {

public boolean isValid(MultipartFile file, ConstraintValidatorContext context) {
    if(file == null || file.isEmpty()){
        return false;
    }
    String contentType = file.getContentType();
    return "image/jpeg".equalsIgnoreCase(contentType);
}
}