package org.example.socialmediamvc.controller;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.example.socialmediamvc.dto.FriendRequestDto;
import org.example.socialmediamvc.dto.PendingFriendRequestDto;
import org.example.socialmediamvc.dto.UserDto;
import org.example.socialmediamvc.enums.FriendRequestStatus;
import org.example.socialmediamvc.service.FriendRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/friends")
public class FriendsController {
    @Autowired
    public FriendRequestService friendRequestService;

    @PostMapping("/add-request")
    public String sendRequest(@ModelAttribute FriendRequestDto friendRequestDto, HttpSession session) {
        log.info("Adding friend request");
        UserDto loggedInUser=(UserDto)session.getAttribute("user");
        friendRequestDto.setSenderId(loggedInUser.getId());
        friendRequestDto.setFriendRequestStatus(FriendRequestStatus.PENDING);
        friendRequestService.sendRequest(friendRequestDto);
        return "redirect:/users/suggestions";
    }

@GetMapping("/view-request")
    public String viewRequest(HttpSession session) {
    UserDto loggedInUser=(UserDto)session.getAttribute("user");
    List<PendingFriendRequestDto> pendingRequest=friendRequestService.getPendingRequest(loggedInUser.getId());
    return "FriendRequest";

}

}
