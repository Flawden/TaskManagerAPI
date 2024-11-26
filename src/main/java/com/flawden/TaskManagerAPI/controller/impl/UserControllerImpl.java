package com.flawden.TaskManagerAPI.controller.impl;

import com.flawden.TaskManagerAPI.controller.UserController;
import com.flawden.TaskManagerAPI.dto.user.UpdateUser;
import com.flawden.TaskManagerAPI.dto.user.User;
import com.flawden.TaskManagerAPI.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<List<User>> getAllUsers(Integer page, Integer size) {
        if (page == null) {
            return ResponseEntity.ok(userService.getAllUsers());
        } else {
            return ResponseEntity.ok(userService.getUsersWithPagination(page, size));
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

    @PatchMapping("/{id}")
    @Override
    public ResponseEntity<HttpStatus> updateUser(UpdateUser user, Long userId) {
        userService.updateUser(user, userId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<HttpStatus> deleteUser(Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user/{username}")
    @Override
    public ResponseEntity<User> getUserByUsername(String username) {
        return ResponseEntity.ok(userService.getUserByUsername(username));
    }

}
