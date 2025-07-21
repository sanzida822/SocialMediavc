package org.example.socialmediamvc.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.socialmediamvc.dto.PostRequestDto;
import org.example.socialmediamvc.dto.UserDto;
import org.example.socialmediamvc.exception.UserNotFoundException;
import org.example.socialmediamvc.mapper.ImageMapper;
import org.example.socialmediamvc.mapper.PostMapper;
import org.example.socialmediamvc.model.*;
import org.example.socialmediamvc.repository.PostRepository;
import org.example.socialmediamvc.repository.UserRepository;
import org.example.socialmediamvc.utils.Constants;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostService {
    private final ImageService imageService;
    private final PostRepository postRepository;
    private final ImageMapper imageMapper;
    private final PostMapper postMapper;
    private final UserService userService;
    private final UserRepository userRepository;

    @Transactional
    public void save(PostRequestDto postRequestDto, UserDto loggedInUser) throws IOException {
        User user = userRepository.findById(loggedInUser.getId())
                .orElseThrow(() -> new UserNotFoundException(Constants.ErrorMessage.USER_NOT_FOUND));

        Post post = postMapper.toEntity(postRequestDto, user);

        if (postRequestDto.getImages() != null) {
            for (MultipartFile imageFile : postRequestDto.getImages()) {
                if (!imageFile.isEmpty()) {
                    Image image = imageMapper.toEntity(imageFile);

                    PostImages postImages = PostImages.builder()
                            .post(post)
                            .image(image)
                            .build();

                    post.getPostImages().add(postImages);
                }
            }
        }

        postRepository.save(post);
    }

}
