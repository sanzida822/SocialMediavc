package org.example.socialmediamvc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class PostResponseDto {
    private Integer id;
    private String content;
    private UserDto user;
    private LocalDateTime createdAt;
    private List<ImageResponseDto> images;
    private String privacy;
}
