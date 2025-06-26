package org.example.socialmediamvc.mapper;
import org.example.socialmediamvc.dto.ImageDto;
import org.example.socialmediamvc.model.Image;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
public class ImageMapper {
    public Image toEntity(MultipartFile profileImage) throws IOException {
       return Image.builder().sizeBytes(profileImage.getSize()).data(profileImage.getBytes()).build();

    }

}
