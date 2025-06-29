package org.example.socialmediamvc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private int id;
    private String username;
    private String email;
    int profileImageId;
    private Timestamp userCreated;
    private Timestamp userUpdated;
}
