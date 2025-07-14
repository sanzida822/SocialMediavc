package org.example.socialmediamvc.controller;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.socialmediamvc.dto.FriendRequestDto;
import org.example.socialmediamvc.dto.FriendRequestViewDto;
import org.example.socialmediamvc.dto.UserDto;
import org.example.socialmediamvc.enums.FriendRequestStatus;
import org.example.socialmediamvc.mapper.FriendRequestMapper;
import org.example.socialmediamvc.service.FriendRequestService;
import org.example.socialmediamvc.service.FriendshipService;
import org.example.socialmediamvc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/friends")
@SessionAttributes("user")
@RequiredArgsConstructor
public class FriendsController {
    private final FriendRequestService friendRequestService;
    private final FriendshipService friendshipService;
    private final FriendRequestMapper friendRequestMapper;
    private final UserService userService;

    @PostMapping("/add-request")
    public String sendRequest(@RequestParam("receiverId") Integer receiverId,
                              @ModelAttribute("user") UserDto sender) {
        log.info("Adding friend request");
       // UserDto sender=(UserDto)session.getAttribute("user");
        UserDto receiver= userService.getUserById(receiverId);
        FriendRequestDto friendRequestDto = FriendRequestDto.builder()
                .sender(sender)
                .receiver(receiver)
                .friendRequestStatus(FriendRequestStatus.PENDING)
                .build();
        friendRequestService.sendRequest(friendRequestDto);
        return "redirect:/users/suggestions";
    }

@GetMapping("/view-request")
    public String viewRequest(@ModelAttribute("user") UserDto loggedInUser, Model model) {
   // UserDto loggedInUser=(UserDto)session.getAttribute("user");
    FriendRequestViewDto viewDto= friendRequestService.getFriendRequestsView(loggedInUser.getId());
    log.info("Get all view request{}",viewDto);
    model.addAttribute("viewDto",viewDto);
    return "FriendRequest";
}

@PostMapping("/accept-request")
    public String acceptRequest(@RequestParam("requestId") Integer requestId) {
            log.info("Accepting request: {}", requestId);
            friendshipService.acceptFriendRequest(requestId);
            return "redirect:/friends/view-request";
}

@PostMapping("/decline-request")
    public String declineRequest(@RequestParam("requestId") Integer requestId ) {
        log.info("Declining request: {}", requestId);
        friendshipService.rejectFriendRequest(requestId);
        return "redirect:/friends/view-request";
}

@PostMapping("/cancel-request")
    public String cancelRequest(@RequestParam("requestId") Integer requestId) {
        friendshipService.rejectFriendRequest(requestId);
        return "redirect:/friends/view-request";
}
}
