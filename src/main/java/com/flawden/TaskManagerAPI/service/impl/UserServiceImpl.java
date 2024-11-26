package com.flawden.TaskManagerAPI.service.impl;

import com.flawden.TaskManagerAPI.config.mappers.UserMapper;
import com.flawden.TaskManagerAPI.dto.user.UpdateUser;
import com.flawden.TaskManagerAPI.dto.user.User;
import com.flawden.TaskManagerAPI.exception.UserNotFoundException;
import com.flawden.TaskManagerAPI.model.UserEntity;
import com.flawden.TaskManagerAPI.repository.UserRepository;
import com.flawden.TaskManagerAPI.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::mapUserEntityToUser)
                .collect(Collectors.toList());
    }

    @Override
    public List<User> getUsersWithPagination(Integer page, Integer size) {
        return userRepository.findAll().stream()
                .map(this::mapUserEntityToUser)
                .collect(Collectors.toList());
    }

    private User mapUserEntityToUser(UserEntity userEntity) {
        return userMapper.mapUserEntityToUser(userEntity);
    }

    @Override
    public User getUserById(Long id) {
        return userMapper.mapUserEntityToUser(userRepository.findById(id).orElseThrow(UserNotFoundException::new));
    }

    @Override
    public User addUser(User user) {
        return userMapper.mapUserEntityToUser(userRepository.save(userMapper.mapUserToUserEntity(user)));
    }

    @Override
    public void updateUser(UpdateUser user, Long userId) {
        UserEntity updatableUser = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        updatableUser.setEmail(user.getEmail());
        updatableUser.setFirstName(user.getFirstName());
        updatableUser.setLastName(user.getLastName());
        userRepository.save(updatableUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return userMapper.mapUserEntityToUser(userRepository.findByEmail(username).orElseThrow(UserNotFoundException::new));
    }
}
