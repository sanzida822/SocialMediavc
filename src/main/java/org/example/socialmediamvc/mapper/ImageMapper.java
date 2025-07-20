package org.example.socialmediamvc.mapper;

import org.example.socialmediamvc.dto.ImageRequestDto;
import org.example.socialmediamvc.model.Image;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
public class ImageMapper {


    public Image toEntity(MultipartFile file) throws IOException {
        return Image.builder().data(file.getBytes())
                .sizeBytes(file.getSize())
                .filename(file.getName())
                .contentType(file.getContentType())
                .build();

    }
}