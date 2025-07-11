package org.example.socialmediamvc.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.socialmediamvc.dto.FriendRequestDto;
import org.example.socialmediamvc.dto.PendingFriendRequestDto;
import org.example.socialmediamvc.enums.FriendRequestStatus;
import org.example.socialmediamvc.exception.FriendRequestException;
import org.example.socialmediamvc.exception.UserNotFoundException;
import org.example.socialmediamvc.mapper.FriendRequestMapper;
import org.example.socialmediamvc.model.FriendRequest;
import org.example.socialmediamvc.model.User;
import org.example.socialmediamvc.repository.FriendRequestRepository;
import org.example.socialmediamvc.repository.UserRepository;
import org.example.socialmediamvc.utils.Constants;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class FriendRequestService {
    private final FriendRequestRepository friendRequestRepository;
    private final UserService userService;
    private final UserRepository userRepository;
    private final FriendRequestMapper friendRequestMapper;

    public void sendRequest (FriendRequestDto friendRequestDto) {
        User sender=userRepository.findById(friendRequestDto.getSenderId()).orElseThrow(()->new UserNotFoundException(Constants.ErrorMessage.USER_NOT_FOUND));
        User receiver=userRepository.findById(friendRequestDto.getReceiverId()).orElseThrow(()->new UserNotFoundException(Constants.ErrorMessage.USER_NOT_FOUND));
        if(friendRequestRepository.existsBySenderAndReceiver(sender, receiver)) {
            throw new FriendRequestException(Constants.ErrorMessage.FRIEND_REQUEST_EXISTS);
        }
        FriendRequest friendRequest=friendRequestMapper.toEntity(friendRequestDto,sender,receiver);
        friendRequestRepository.save(friendRequest);

    }


    public List<PendingFriendRequestDto> getPendingRequest(int receiverId) {
      friendRequestRepository.findPendingFriendRequests(receiverId);
      List<FriendRequest> pendingRequests=friendRequestRepository.findPendingFriendRequests(receiverId);
      return pendingRequests.stream().map(friendRequestMapper::toDto).collect(Collectors.toList());
    }


}
