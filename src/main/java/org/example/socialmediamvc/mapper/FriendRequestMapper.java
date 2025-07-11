package org.example.socialmediamvc.mapper;

import lombok.RequiredArgsConstructor;
import org.example.socialmediamvc.dto.FriendRequestDto;
import org.example.socialmediamvc.dto.PendingFriendRequestDto;
import org.example.socialmediamvc.model.FriendRequest;
import org.example.socialmediamvc.model.User;
import org.example.socialmediamvc.repository.FriendRequestRepository;
import org.example.socialmediamvc.repository.UserRepository;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FriendRequestMapper {
private final UserRepository userRepository;
    public FriendRequest toEntity(FriendRequestDto friendRequestDto, User sender, User receiver) {
        return FriendRequest.builder().sender(sender)
                .receiver(receiver)
                .friendRequestStatus(friendRequestDto.getFriendRequestStatus()).build();

    }

    public PendingFriendRequestDto toDto(FriendRequest friendRequest) {
        return PendingFriendRequestDto.builder()
                .id(friendRequest.getId())
                .senderId(friendRequest.getSender().getId())
                .senderName(friendRequest.getSender().getUsername())
                .sentAt(friendRequest.getCreatedAt()).build();
    }

//    public FriendRequestDto toDto(FriendRequest friendRequest) {
//        return FriendRequestDto.builder().senderId(friendRequest.getSender().getId())
//                .receiverId(friendRequest.getReceiver().getId())
//                 .friendRequestStatus(friendRequest.getFriendRequestStatus()).build();
//
//    }
}
