package org.example.socialmediamvc.mapper;

import org.example.socialmediamvc.dto.ImageRequestDto;
import org.example.socialmediamvc.model.Image;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
public class ImageMapper {


public Image toEntity(ImageRequestDto imageRequestDtoDto) throws IOException {
    MultipartFile imageFile = imageRequestDtoDto.getImage();
    return Image.builder().data(imageFile.getBytes())
            .filename(imageFile.getName())
            .sizeBytes(imageFile.getSize())
            .contentType(imageFile.getContentType())
            .build();

}

}
