package org.example.socialmediamvc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.socialmediamvc.enums.FriendRequestStatus;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FriendRequestDto {
    int id;
    private int senderId;
    private int receiverId;
    private FriendRequestStatus friendRequestStatus;
    private String friendRequestSent;

}
