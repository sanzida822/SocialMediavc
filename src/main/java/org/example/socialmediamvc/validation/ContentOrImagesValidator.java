package org.example.socialmediamvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.socialmediamvc.dto.PostRequestDto;

public class ContentOrImagesValidator implements ConstraintValidator<ContentOrImages, PostRequestDto> {

    public boolean isValid(PostRequestDto postRequestDto, ConstraintValidatorContext context) {
        boolean hasContent = postRequestDto.getContent() != null && !postRequestDto.getContent().trim().isEmpty();
        boolean hasImages = postRequestDto.getImages() != null && !postRequestDto.getImages().isEmpty();
        return hasContent || hasImages;}
}
