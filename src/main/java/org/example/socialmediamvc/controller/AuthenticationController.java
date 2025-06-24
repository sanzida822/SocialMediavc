package org.example.socialmediamvc.controller;
import org.example.socialmediamvc.dto.RegistrationRequestDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/auth")
public class AuthenticationController {
    @GetMapping("/register")
    public String processRegistration(Model model) {
        model.addAttribute("registrationRequestDto", new RegistrationRequestDto());
        return "registrationForm";
    }

    @PostMapping("/register")

    public String registerUser(@Valid @ModelAttribute("registrationRequestDto") RegistrationRequestDto registrationRequestDto, BindingResult bindingResult) {
        System.out.println("cpass: " + registrationRequestDto.getConfirmPassword());
        if(bindingResult.hasErrors()) {
            System.out.println("hgvcx");
            System.out.printf("Error: %s\n", bindingResult.getFieldError().getDefaultMessage());
        }
        return "registrationForm";

    }


}
