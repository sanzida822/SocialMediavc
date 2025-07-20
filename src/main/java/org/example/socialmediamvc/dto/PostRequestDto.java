package org.example.socialmediamvc.dto;

import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.socialmediamvc.enums.Privacy;
import org.example.socialmediamvc.utils.Constants;
import org.example.socialmediamvc.validation.ContentOrImages;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

@ContentOrImages
public class PostRequestDto {
    private int id;

    @NotNull()
    private Privacy privacy;

    @Size(max = 255, message = Constants.ErrorMessage.POST_CONTENT_LENGTH)
    private String content;

    private MultipartFile[] images;
//    @Transient
//    private List<ImageRequestDto> images;

}
