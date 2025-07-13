package org.example.socialmediamvc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FriendRequestViewDto {
    List<FriendRequestDto> sentRequests;
    List<FriendRequestDto> receivedRequests;
}
