package com.d19.demo.repositories.user;

import com.d19.demo.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {
    User getUserByUsername(String username);
    User getUserByUsernameAndPassword(String username, String getUserByUsername);
}
