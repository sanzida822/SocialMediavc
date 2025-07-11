package org.example.socialmediamvc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PendingFriendRequestDto {
    private int id;
    private Integer senderId;
    private String senderName;
    private LocalDateTime sentAt;
}
