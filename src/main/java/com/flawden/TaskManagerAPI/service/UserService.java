package com.flawden.TaskManagerAPI.service;

import com.flawden.TaskManagerAPI.dto.user.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    List<User> getUsersWithPagination(int page);
    User getUserById(Long id);
    User addUser(User user);
    User updateUser(User user);
    User deleteUser(Long id);
    User getUserByUsername(String username);

}
