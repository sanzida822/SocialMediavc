package org.example.socialmediamvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/home")
public class HomeController {

    public String home() {
        return "home";
    }

}
