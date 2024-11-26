package com.flawden.TaskManagerAPI.controller;

import com.flawden.TaskManagerAPI.dto.user.UpdateUser;
import com.flawden.TaskManagerAPI.dto.user.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UserController {

    ResponseEntity<List<User>> getAllUsers(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "limit", required = false) Integer limit);
    ResponseEntity<User> getUserById(@PathVariable Long id);
    ResponseEntity<User> addUser(@RequestBody User user);
    ResponseEntity<HttpStatus> updateUser(@RequestBody UpdateUser user, @PathVariable Long userId);
    ResponseEntity<HttpStatus> deleteUser(@PathVariable Long id);
    ResponseEntity<User> getUserByUsername(@PathVariable String username);

}
