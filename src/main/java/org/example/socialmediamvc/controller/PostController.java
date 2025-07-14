package org.example.socialmediamvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class PostController {
    @GetMapping("/showAllPosts")
    public String home() {
        return "home";
    }

    @PostMapping("/create")
    public String createPost(){
        return "create";
    }

    @PostMapping("/delete")
    public String deletePost(){
        return "delete";
    }
    }

