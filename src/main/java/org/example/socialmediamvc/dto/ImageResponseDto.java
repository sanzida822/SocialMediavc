package org.example.socialmediamvc.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.socialmediamvc.utils.Constants;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class ImageResponseDto {
    private int id;
    private MultipartFile file;
    private String fileName;
    private String contentType;

}
