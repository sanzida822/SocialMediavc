package org.example.socialmediamvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/users")
@Controller
public class UserController {
    @GetMapping("/suggestions")
    public String exploreUsers() {
        return "explore-people";
    }
}
