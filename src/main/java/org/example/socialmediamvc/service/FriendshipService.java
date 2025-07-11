package org.example.socialmediamvc.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.socialmediamvc.model.FriendRequest;
import org.example.socialmediamvc.repository.FriendRequestRepository;
import org.example.socialmediamvc.repository.FriendshipRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class FriendshipService {
    private final FriendshipRepository friendshipRepository;
    private final FriendRequestRepository friendRequestRepository ;
    public void acceptFriendRequest(int friendRequestId) {
        FriendRequest request= friendRequestRepository.findById(friendRequestId).orElseThrow("");
        friendshipRepository.acceptFriendRequest(friendRequestId);
    }
}
