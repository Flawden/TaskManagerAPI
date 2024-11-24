package com.flawden.TaskManagerAPI.controller;

import com.flawden.TaskManagerAPI.dto.user.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserController {

    ResponseEntity<List<User>> getAllUsers();
    ResponseEntity<List<User>> getUsersWithPagination(int page);
    ResponseEntity<User> getUserById(Long id);
    ResponseEntity<User> addUser(User user);
    ResponseEntity<User> updateUser(User user);
    ResponseEntity<User> deleteUser(Long id);
    ResponseEntity<User> getUserByUsername(String username);

}
