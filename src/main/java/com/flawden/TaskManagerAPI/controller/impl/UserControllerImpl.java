package com.flawden.TaskManagerAPI.controller.impl;

import com.flawden.TaskManagerAPI.controller.UserController;
import com.flawden.TaskManagerAPI.dto.user.User;
import com.flawden.TaskManagerAPI.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @GetMapping
    @Override
    public ResponseEntity<List<User>> getAllUsers(Long page) {
        if (page == null) {
            return ResponseEntity.ok(userService.getAllUsers());
        } else {
            return ResponseEntity.ok(userService.getUsersWithPagination(page));
        }
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<User> getUserById(Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping
    @Override
    public ResponseEntity<User> addUser(User user) {
        return ResponseEntity.ok(userService.addUser(user));
    }

    @PatchMapping
    @Override
    public ResponseEntity<User> updateUser(User user) {
        return ResponseEntity.ok(userService.updateUser(user));
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<User> deleteUser(Long id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }

    @GetMapping("/user/{username}")
    @Override
    public ResponseEntity<User> getUserByUsername(String username) {
        return ResponseEntity.ok(userService.getUserByUsername(username));
    }

}
