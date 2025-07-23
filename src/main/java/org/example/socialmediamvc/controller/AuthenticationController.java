package org.example.socialmediamvc.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.socialmediamvc.dto.LoginRequestDto;
import org.example.socialmediamvc.dto.RegistrationRequestDto;
import org.example.socialmediamvc.dto.UserDto;
import org.example.socialmediamvc.service.UserService;
import org.example.socialmediamvc.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@Slf4j
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("registrationRequestDto", new RegistrationRequestDto());
        return "registrationForm";
    }

    @PostMapping("/register")
    public String processRegistration(@Valid @ModelAttribute("registrationRequestDto") RegistrationRequestDto registrationRequestDto, BindingResult bindingResult, Model model) throws IOException {
        log.info("Registration request dto:{}", registrationRequestDto);

        if (bindingResult.hasErrors()) {
            log.error("BindingResult has errors:{} ", bindingResult.hasErrors());
            return "registrationForm";
        }
        userService.register(registrationRequestDto);
        return "redirect:/auth/login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "loginForm";
    }

    @PostMapping("/login")
    public String processLogin(@Valid @ModelAttribute("loginRequestDto") LoginRequestDto loginRequestDto, BindingResult bindingResult, Model model, HttpSession httpSession) throws IOException {
        if (bindingResult.hasErrors()) {
            log.error("BindingResult has errors:{} ", bindingResult.hasErrors());
            return "loginForm";
        }
        UserDto userDto = userService.verifyLogin(loginRequestDto);
        if (userDto == null) {
            model.addAttribute("loginError", Constants.ErrorMessage.INVALID_EMAIL_PASSWORD);
            return "loginForm";
        }
        httpSession.setAttribute("user", userDto);
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String processLogout(HttpSession httpSession) {
        httpSession.invalidate();
        return "redirect:/auth/login";
    }

}
