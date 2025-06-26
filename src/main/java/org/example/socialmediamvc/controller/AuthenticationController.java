package org.example.socialmediamvc.controller;
import org.example.socialmediamvc.dto.RegistrationRequestDto;
import org.example.socialmediamvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.io.IOException;

@Controller
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private UserService userService;
    @GetMapping("/register")
    public String processRegistration(Model model) {
        model.addAttribute("registrationRequestDto", new RegistrationRequestDto());
        return "registrationForm";
    }

    @PostMapping("/register")

    public String registerUser(@Valid @ModelAttribute("registrationRequestDto") RegistrationRequestDto registrationRequestDto,
                               BindingResult bindingResult) throws IOException {
        System.out.println("cpass: " + registrationRequestDto.getConfirmPassword());

        if (bindingResult.hasErrors()) {
            System.out.println("errors: " + bindingResult.getAllErrors());
            return "registrationForm";
        }
        userService.register(registrationRequestDto);
        return "redirect:/loginForm";
    }



}
