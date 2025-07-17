package org.example.socialmediamvc.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.socialmediamvc.utils.Constants;
import org.example.socialmediamvc.validation.AllowedImageType;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
@AllArgsConstructor
@NoArgsConstructor
@Data

public class ImageRequestDto {
    @NotNull(message=Constants.ErrorMessage.IMAGE_REQUIRED)
    @AllowedImageType
    private MultipartFile image;




}
