package org.example.socialmediamvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.socialmediamvc.dto.ImageRequestDto;
import org.example.socialmediamvc.dto.PostRequestDto;
import org.example.socialmediamvc.dto.UserDto;
import org.example.socialmediamvc.service.PostService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;
import java.util.stream.Collectors;

@Controller
@Slf4j
@SessionAttributes("")
@RequiredArgsConstructor
public class PostController {
    private  final PostService postService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String createPost(@Valid @ModelAttribute PostRequestDto postRequestDto, BindingResult bindingResult,
                             @RequestParam(value = "images", required = false) MultipartFile[] imageFiles,
                             HttpServletRequest request, HttpSession session) {
        UserDto loggedInUser=(UserDto)session.getAttribute("user");
        log.info("Received POST request for post: {}", request.getParameter("privacy"));

        if (bindingResult.hasErrors()) {
            log.error("Validation errors in post creation: {}", bindingResult.getAllErrors());
            return "home";
        }
        postService.save(postRequestDto,loggedInUser);
        log.info("Received POST request for post: {}", postRequestDto);

        return "home";
    }

    @PostMapping("/delete")
    public String deletePost(){
        return "delete";
    }
    }

