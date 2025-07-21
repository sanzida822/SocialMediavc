package org.example.socialmediamvc.service;

import lombok.RequiredArgsConstructor;
import org.example.socialmediamvc.mapper.ImageMapper;
import org.example.socialmediamvc.model.Image;
import org.example.socialmediamvc.repository.ImageRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final ImageRepository imageRepository;
    private final ImageMapper imageMapper;

    @Transactional
    public Image save(MultipartFile imageFile) throws IOException {
        Image image = imageMapper.toEntity(imageFile);
      return   imageRepository.save(image);
    }



}
