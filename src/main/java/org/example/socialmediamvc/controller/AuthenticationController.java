package org.example.socialmediamvc.controller;
import org.example.socialmediamvc.dto.RegistrationRequestDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthenticationController {
    @GetMapping("/register")
    public String processRegistration(){
        return "registrationForm";
    }

    @PostMapping("/register")
    public String processRegistration( @ModelAttribute("registrationRequestDto") RegistrationRequestDto registrationRequestDto,
                                      BindingResult bindingResult, Model model){
        System.out.println("Username: " + registrationRequestDto.getUserName());
        System.out.println("Email: " + registrationRequestDto.getEmail());
        if(bindingResult.hasErrors()){
            System.out.println("Errors encountered");
            return "registrationForm";
        }


        return "registrationForm";

    }
}
