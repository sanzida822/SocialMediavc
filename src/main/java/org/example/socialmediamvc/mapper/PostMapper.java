package org.example.socialmediamvc.mapper;

import lombok.RequiredArgsConstructor;
import org.example.socialmediamvc.dto.PostRequestDto;
import org.example.socialmediamvc.dto.UserDto;
import org.example.socialmediamvc.model.Post;
import org.example.socialmediamvc.model.User;
import org.example.socialmediamvc.repository.UserRepository;
import org.example.socialmediamvc.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class PostMapper {
    private final UserMapper userMapper;

    public Post toEntity(PostRequestDto postRequestDto, User user) {

        return Post.builder().content(postRequestDto.getContent())
                .postedBy(user)
                .privacy(postRequestDto.getPrivacy())
                .build();

    }
}
