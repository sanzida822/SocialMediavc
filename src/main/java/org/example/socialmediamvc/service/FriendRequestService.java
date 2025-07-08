package org.example.socialmediamvc.service;

import com.sun.jdi.request.DuplicateRequestException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.socialmediamvc.enums.FriendRequestStatus;
import org.example.socialmediamvc.exception.FriendRequestException;
import org.example.socialmediamvc.model.FriendRequest;
import org.example.socialmediamvc.model.User;
import org.example.socialmediamvc.repository.FriendRequestRepository;
import org.example.socialmediamvc.utils.Constants;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class FriendRequestService {
    private FriendRequestRepository friendRequestRepository;
    private UserService userService;

    public FriendRequest sendRequest (int senderId, int receiverId) {
        User sender=userService.getUserById(senderId);
        User receiver=userService.getUserById(receiverId);
        if(friendRequestRepository.existsBySenderAndReceiver(sender, receiver)) {
            throw new FriendRequestException(Constants.ErrorMessage.FRIEND_REQUEST_EXISTS);
        }
        return friendRequestRepository.save(
                 FriendRequest.builder()
                        .sender(sender)
                        .receiver(receiver)
                        .friendRequestStatus(FriendRequestStatus.PENDING)
                        .build()
        );

    }



}
