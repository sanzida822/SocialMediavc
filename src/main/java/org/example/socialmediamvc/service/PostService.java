package org.example.socialmediamvc.service;

import lombok.RequiredArgsConstructor;
import org.example.socialmediamvc.dto.PostRequestDto;
import org.example.socialmediamvc.dto.UserDto;
import org.example.socialmediamvc.exception.UserNotFoundException;
import org.example.socialmediamvc.mapper.ImageMapper;
import org.example.socialmediamvc.mapper.PostMapper;
import org.example.socialmediamvc.model.Image;
import org.example.socialmediamvc.model.Post;
import org.example.socialmediamvc.model.User;
import org.example.socialmediamvc.repository.PostRepository;
import org.example.socialmediamvc.repository.UserRepository;
import org.example.socialmediamvc.utils.Constants;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {
    private ImageService imageService;
    private PostRepository postRepository;
    private PostMapper postMapper;
    private UserService userService;
    private final UserRepository userRepository;

    public void save(PostRequestDto postRequestDto, UserDto loggedInUser) throws IOException {
        User user = userRepository.findById(loggedInUser.getId()).orElseThrow(()->new  UserNotFoundException(Constants.ErrorMessage.USER_NOT_FOUND));
        Post post = postMapper.toEntity(postRequestDto,user);
        postRepository.save(post);

        if(postRequestDto.getImages() != null) {
            for(MultipartFile imageFile : postRequestDto.getImages()) {
                if(!imageFile.isEmpty()) {
                    Image image=imageService.save(imageFile);


                }
            }

        }

    }
}
