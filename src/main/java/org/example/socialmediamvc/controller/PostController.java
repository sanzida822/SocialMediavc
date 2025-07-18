package org.example.socialmediamvc.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.example.socialmediamvc.dto.PostRequestDto;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;

@Controller
@Slf4j
@SessionAttributes("")
public class PostController {
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String createPost(@Valid @ModelAttribute PostRequestDto postRequestDto, BindingResult bindingResult) {
        log.info("Received POST request for post: {}", postRequestDto);

        return "home";
    }

    @PostMapping("/delete")
    public String deletePost(){
        return "delete";
    }
    }

