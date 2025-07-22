package org.example.socialmediamvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.socialmediamvc.dto.PostRequestDto;
import org.example.socialmediamvc.dto.PostResponseDto;
import org.example.socialmediamvc.dto.UserDto;
import org.example.socialmediamvc.service.PostService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@Slf4j
@SessionAttributes("")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/")
    public String home(HttpSession session, Model model) {
        UserDto loggedInUser = (UserDto) session.getAttribute("user");
        List<PostResponseDto> posts = postService.getVisiblePostsForCurrentUser(loggedInUser);
        model.addAttribute("posts", posts);
        for (PostResponseDto post : posts) {
            log.info("Post ID: {}, Content: {}, User: {}, Images: {}",
                    post.getId(),
                    post.getContent(),
                    post.getUser().getUsername(),
                    post.getImages());
        }
        return "home";
    }

    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String createPost(@Valid @ModelAttribute PostRequestDto postRequestDto, BindingResult bindingResult, @RequestParam(value = "images", required = false) MultipartFile[] imageFiles, HttpServletRequest request, HttpSession session) throws IOException {
        UserDto loggedInUser = (UserDto) session.getAttribute("user");
        log.info("Received POST request for post: {}", request.getParameter("privacy"));

        if (bindingResult.hasErrors()) {
            log.error("Validation errors in post creation: {}", bindingResult.getAllErrors());
            return "home";
        }
        log.info("Received POST request for post: {}", postRequestDto);
        postService.save(postRequestDto, loggedInUser);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deletePost() {
        return "delete";
    }
}

