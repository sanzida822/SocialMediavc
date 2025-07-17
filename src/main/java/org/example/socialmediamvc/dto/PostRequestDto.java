package org.example.socialmediamvc.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.socialmediamvc.enums.Privacy;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class PostRequestDto {
    private int id;

    @NotNull()
    private Privacy privacy;

    @NotBlank()
    private String content;
    private List<ImageDto> images;



}
