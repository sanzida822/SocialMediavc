package org.example.socialmediamvc.mapper;
import org.example.socialmediamvc.dto.ImageDto;
import org.example.socialmediamvc.model.Image;
import org.springframework.stereotype.Component;

@Component
public class ImageMapper {
    public Image toEntity(ImageDto imageDto) {
       return Image.builder().data(imageDto.getData()).build();

    }

}
