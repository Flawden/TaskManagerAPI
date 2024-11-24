package com.flawden.TaskManagerAPI.controller.impl;

import com.flawden.TaskManagerAPI.controller.UserController;
import com.flawden.TaskManagerAPI.dto.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    public ResponseEntity<List<User>> getAllUsers() {
        return null;
    }

    @Override
    public ResponseEntity<List<User>> getUsersWithPagination(int page) {
        return null;
    }

    @Override
    public ResponseEntity<User> getUserById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<User> addUser(User user) {
        return null;
    }

    @Override
    public ResponseEntity<User> updateUser(User user) {
        return null;
    }

    @Override
    public ResponseEntity<User> deleteUser(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<User> getUserByUsername(String username) {
        return null;
    }

}
