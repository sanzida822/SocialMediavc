package org.example.socialmediamvc.service;

import jakarta.persistence.EntityNotFoundException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.socialmediamvc.model.FriendRequest;
import org.example.socialmediamvc.repository.FriendRequestRepository;
import org.example.socialmediamvc.repository.FriendshipRepository;
import org.example.socialmediamvc.utils.Constants;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class FriendshipService {
    private final FriendshipRepository friendshipRepository;
    private final FriendRequestRepository friendRequestRepository ;
    private final FriendRequestService friendRequestService;

    public void acceptFriendRequest(int requestId) {
        log.info("Accepting friend request {}", requestId);
        FriendRequest friendRequest= friendRequestService.findById(requestId);
        friendshipRepository.acceptFriendRequest(requestId);
        friendRequestService.deleteById(requestId);
    }

    public void rejectFriendRequest(int requestId) {
        log.info("Rejecting friend request {}", requestId);
        FriendRequest friendRequest= friendRequestService.findById(requestId);
        friendRequestService.deleteById(requestId);
    }
}
