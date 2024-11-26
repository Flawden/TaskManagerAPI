package com.flawden.TaskManagerAPI.service.impl;

import com.flawden.TaskManagerAPI.dto.user.User;
import com.flawden.TaskManagerAPI.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Override
    public List<User> getAllUsers() {
        return List.of();
    }

    @Override
    public List<User> getUsersWithPagination(Integer page, Integer size) {
        return List.of();
    }

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public User addUser(User user) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }

    @Override
    public User getUserByUsername(String username) {
        return null;
    }
}
