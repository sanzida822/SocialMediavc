package org.example.socialmediamvc.service;

import org.example.socialmediamvc.model.User;
import org.example.socialmediamvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public boolean emailExists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

}
