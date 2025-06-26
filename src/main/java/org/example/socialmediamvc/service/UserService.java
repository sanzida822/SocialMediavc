package org.example.socialmediamvc.service;

import org.example.socialmediamvc.dto.RegistrationRequestDto;
import org.example.socialmediamvc.mapper.ImageMapper;
import org.example.socialmediamvc.mapper.UserMapper;
import org.example.socialmediamvc.model.Image;
import org.example.socialmediamvc.model.User;
import org.example.socialmediamvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ImageMapper imageMapper;
    public boolean emailExists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    public  User register(RegistrationRequestDto registrationRequestDto) throws IOException {
        Image profileImage = imageMapper.toEntity(registrationRequestDto.getProfileImage());
        User user=userMapper.toEntity(registrationRequestDto, profileImage);
        return userRepository.save(user);

    }
}
