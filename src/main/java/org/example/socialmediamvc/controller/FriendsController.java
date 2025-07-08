package org.example.socialmediamvc.controller;

import jakarta.servlet.http.HttpSession;
import org.example.socialmediamvc.dto.UserDto;
import org.example.socialmediamvc.service.FriendRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/friends")
public class FriendsController {
    @Autowired
    public FriendRequestService friendRequestService;

    @PostMapping("/add-request")
    public String sendRequest(@RequestParam int receiverId, HttpSession session) {
        UserDto loggedInUser=(UserDto)session.getAttribute("user");
        int senderId=loggedInUser.getId();
        friendRequestService.sendRequest(senderId, receiverId);
        return "redirect:/users/userSuggestions";




    }

}
