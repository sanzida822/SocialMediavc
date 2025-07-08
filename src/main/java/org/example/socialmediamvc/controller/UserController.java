package org.example.socialmediamvc.controller;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.example.socialmediamvc.dto.UserDto;
import org.example.socialmediamvc.service.UserService;
import org.example.socialmediamvc.utils.CommonUtil;
import org.example.socialmediamvc.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/users")
@Controller
@Slf4j
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/suggestions")
    public String getSuggestedUsers(HttpSession session, Model model) {
        UserDto loggedInUser=(UserDto)session.getAttribute("user");
        List<UserDto> userSuggestions =userService.getNonFriendUsers(loggedInUser.getId());
        model.addAttribute("suggestedUsers", userSuggestions);
        return "userSuggestions";
    }



}
