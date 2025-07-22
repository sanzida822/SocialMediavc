package org.example.socialmediamvc.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.example.socialmediamvc.dto.ImageResponseDto;
import org.example.socialmediamvc.model.Image;
import org.example.socialmediamvc.service.ImageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/images")
@RequiredArgsConstructor
public class ImageController {
    private final ImageService imageService;
    @GetMapping("/{id}")
    public void getImage(@PathVariable("id") int id, HttpServletResponse response) throws IOException {
        Image image = imageService.getImageById(id);
        response.setContentType(image.getContentType());
        response.getOutputStream().write(image.getData());
        response.getOutputStream().flush();
    }
}
