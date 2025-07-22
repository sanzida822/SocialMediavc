package org.example.socialmediamvc.mapper;

import lombok.RequiredArgsConstructor;
import org.example.socialmediamvc.dto.ImageResponseDto;
import org.example.socialmediamvc.dto.PostRequestDto;
import org.example.socialmediamvc.dto.PostResponseDto;
import org.example.socialmediamvc.dto.UserDto;
import org.example.socialmediamvc.model.Post;
import org.example.socialmediamvc.model.PostImages;
import org.example.socialmediamvc.model.User;
import org.example.socialmediamvc.repository.UserRepository;
import org.example.socialmediamvc.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PostMapper {
    private final UserMapper userMapper;
    private final ImageMapper imageMapper;
    private final ImageResponseDto imageResponseDto;

    public Post toEntity(PostRequestDto postRequestDto, User user) {
        return Post.builder().content(postRequestDto.getContent())
                .postedBy(user)
                .privacy(postRequestDto.getPrivacy())
                .build();
    }

    public PostResponseDto toDto(Post post, User user) {
        return PostResponseDto.builder().id(post.getId())
                .content(post.getContent())
                .createdAt(post.getCreatedAt())
                .user(userMapper.toDto(user))
                .images(toDto(post.getPostImages()))
                .build();
    }

    public List<ImageResponseDto> toDto(List<PostImages> postImages) {
        return postImages.stream().map(PostImages::getImage)
                .map(imageMapper::toDto)
                .collect(Collectors.toList());
    }


    public List<PostResponseDto> toDtoList(List<Post> posts) {
        return posts.stream()
                .map(post -> PostResponseDto.builder()
                        .id(post.getId())
                        .content(post.getContent())
                        .user(userMapper.toDto(post.getPostedBy()))
                        .createdAt(post.getCreatedAt())
                        .images(toDto(post.getPostImages()))
                        .build())
                .collect(Collectors.toList());
    }
}
