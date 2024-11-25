package com.flawden.TaskManagerAPI.controller.impl;

import com.flawden.TaskManagerAPI.controller.UserController;
import com.flawden.TaskManagerAPI.dto.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    @GetMapping
    @Override
    public ResponseEntity<List<User>> getAllUsers(Long page) {
        return null;
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<User> getUserById(Long id) {
        return null;
    }

    @PostMapping
    @Override
    public ResponseEntity<User> addUser(User user) {
        return null;
    }

    @PatchMapping
    @Override
    public ResponseEntity<User> updateUser(User user) {
        return null;
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<User> deleteUser(Long id) {
        return null;
    }

    @GetMapping("/user/{username}")
    @Override
    public ResponseEntity<User> getUserByUsername(String username) {
        return null;
    }

}
