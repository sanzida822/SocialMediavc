package org.example.socialmediamvc.service;

import org.example.socialmediamvc.dao.UserDao;
import org.example.socialmediamvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    public void saveUser(User user) {
        userDao.save(user);
    }
}
