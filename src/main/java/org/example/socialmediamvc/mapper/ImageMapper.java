package org.example.socialmediamvc.mapper;

import org.example.socialmediamvc.model.Image;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
public class ImageMapper {


    public Image toEntity(MultipartFile imageFile) throws IOException {
        return Image.builder().data(imageFile.getBytes())
                .sizeBytes(imageFile.getSize())
                .filename(imageFile.getOriginalFilename())
                .contentType(imageFile.getContentType())
                .build();

    }
}