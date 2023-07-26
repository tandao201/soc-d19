package com.d19.demo.repositories.user;

import com.d19.demo.models.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    IUserRepository iUserRepository;

    public User getUserByUsername(String username) {
        return iUserRepository.getUserByUsername(username);
    }

    public User getUserByUsernameAndPassword(String username, String password) {
        return iUserRepository.getUserByUsernameAndPassword(username, password);
    }

    public User register(User user) {
        return iUserRepository.save(user);
    }
}
