package com.flawden.TaskManagerAPI.service.impl;

import com.flawden.TaskManagerAPI.config.mappers.UserMapper;
import com.flawden.TaskManagerAPI.config.security.PersonDetailService;
import com.flawden.TaskManagerAPI.config.security.PersonDetails;
import com.flawden.TaskManagerAPI.dto.*;
import com.flawden.TaskManagerAPI.model.UserEntity;
import com.flawden.TaskManagerAPI.repository.UserRepository;
import com.flawden.TaskManagerAPI.service.AuthService;
import com.flawden.TaskManagerAPI.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserMapper userMapper;

    @Override
    public AuthenticationResponse register(Register register) {
        register.setPassword(passwordEncoder.encode(register.getPassword()));
        UserEntity user = userMapper.mapRegisterToUserEntity(register);
        userRepository.save(user);
        return AuthenticationResponse.builder()
                .token(jwtService.generateToken(new PersonDetails(user)))
                .build();
    }

    @Override
    public AuthenticationResponse login(Login login) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));
        UserEntity user = userRepository.findByEmail(login.getUsername()).orElseThrow(() -> new UsernameNotFoundException("Bad credential"));
        return AuthenticationResponse.builder()
                .token(jwtService.generateToken(new PersonDetails(user)))
                .build();
    }
}
