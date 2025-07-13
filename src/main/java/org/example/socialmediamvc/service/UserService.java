package org.example.socialmediamvc.service;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.socialmediamvc.dto.LoginRequestDto;
import org.example.socialmediamvc.dto.RegistrationRequestDto;
import org.example.socialmediamvc.dto.UserDto;
import org.example.socialmediamvc.exception.UserNotFoundException;
import org.example.socialmediamvc.mapper.ImageMapper;
import org.example.socialmediamvc.mapper.UserMapper;
import org.example.socialmediamvc.model.User;
import org.example.socialmediamvc.repository.UserRepository;
import org.example.socialmediamvc.utils.Constants;
import org.example.socialmediamvc.utils.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final ImageMapper imageMapper;
    public UserDto emailExists(String email) {
      return   userRepository.findByEmail(email).map(userMapper::toDto).orElse(null);

    }

    public void register(RegistrationRequestDto registrationRequestDto) throws IOException {
       // Image profileImage = imageMapper.toEntity(registrationRequestDto.getProfileImage());
     //   User user=userMapper.toEntity(registrationRequestDto, profileImage);
        User user=userMapper.toEntity(registrationRequestDto);
        userRepository.save(user);

    }

    public UserDto verifyLogin(LoginRequestDto loginRequestDto) throws IOException {
        Optional <User> user = userRepository.findByEmail(loginRequestDto.getEmail());
        if(user.isEmpty()){
            return null;
        }
        User userEntity=user.get();
        boolean isPasswordValid=PasswordUtil.verifyPassword(loginRequestDto.getPassword(), userEntity.getPassword());
        if(isPasswordValid){
            return userMapper.toDto(userEntity);
        }
        return null;
    }

    public List<UserDto> getNonFriendUsers(int loggedInUserId) {
       List<User> nonFriendUsers=userRepository.findNonFriendUsers(loggedInUserId);
       return userRepository.findNonFriendUsers(loggedInUserId).stream().map(userMapper::toDto).toList();
    }

    public UserDto getUserById(int userId) {
        User user= userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException(Constants.ErrorMessage.USER_NOT_FOUND));
        return userMapper.toDto(user);
    }

}
