package org.example.socialmediamvc.mapper;

import org.example.socialmediamvc.dto.ImageResponseDto;
import org.example.socialmediamvc.model.Image;
import org.example.socialmediamvc.model.PostImages;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Component
public class ImageMapper {


    public Image toEntity(MultipartFile imageFile) throws IOException {
        return Image.builder().data(imageFile.getBytes())
                .sizeBytes(imageFile.getSize())
                .filename(imageFile.getOriginalFilename())
                .contentType(imageFile.getContentType())
                .build();

    }

    public ImageResponseDto toDto(Image image) {
        String base64Image = Base64.getEncoder().encodeToString(image.getData());
        return ImageResponseDto.builder()
                .id(image.getId())
                .base64Data(base64Image)
                .contentType(image.getContentType())
                .fileName(image.getFilename())
                .build();


    }


}