package org.example.socialmediamvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/auth")
public class AuthenticationController {
    @GetMapping("/register")
    public String processRegistration(){
        return "registrationForm";
    }

//    @PostMapping("/register")
//    public String processRegistration(@RequestParam('username') String userName, @RequestParam('email') String email,
//                                      @RequestParam('password') String password, @RequestParam('confirm_password') String confirmPassword,
//                                      @RequestParam('image') MultipartFile image, Model model,){
//
//    }
}
