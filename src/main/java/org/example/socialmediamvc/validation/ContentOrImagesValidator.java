package org.example.socialmediamvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;
import org.example.socialmediamvc.dto.PostRequestDto;

import java.util.Arrays;

@Slf4j
public class ContentOrImagesValidator implements ConstraintValidator<ContentOrImages, PostRequestDto> {

    public boolean isValid(PostRequestDto postRequestDto, ConstraintValidatorContext context) {
        log.info("Running ContentOrImages validation");
        boolean hasContent = postRequestDto.getContent() != null && !postRequestDto.getContent().trim().isEmpty();
        boolean hasImages = postRequestDto.getImages() != null &&
                Arrays.stream(postRequestDto.getImages())
                        .anyMatch(file -> !file.isEmpty());
        return hasContent || hasImages;}
}
