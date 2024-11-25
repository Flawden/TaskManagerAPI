package com.flawden.TaskManagerAPI.controller;

import com.flawden.TaskManagerAPI.dto.user.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UserController {

    ResponseEntity<List<User>> getAllUsers(@RequestParam(value = "page", required = false) Long page);
    ResponseEntity<User> getUserById(@RequestParam Long id);
    ResponseEntity<User> addUser(@RequestBody User user);
    ResponseEntity<User> updateUser(@RequestBody User user);
    ResponseEntity<User> deleteUser(@RequestParam Long id);
    ResponseEntity<User> getUserByUsername(@RequestParam String username);

}
