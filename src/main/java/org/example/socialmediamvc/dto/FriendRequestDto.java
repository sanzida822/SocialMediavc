package org.example.socialmediamvc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.socialmediamvc.enums.FriendRequestStatus;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FriendRequestDto {
    int id;
    private UserDto sender;
    private UserDto receiver;
    private FriendRequestStatus friendRequestStatus;
    private LocalDateTime friendRequestSent;

}
