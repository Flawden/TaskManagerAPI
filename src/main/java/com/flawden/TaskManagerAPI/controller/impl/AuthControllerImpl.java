package com.flawden.TaskManagerAPI.controller.impl;

import com.flawden.TaskManagerAPI.controller.AuthController;
import com.flawden.TaskManagerAPI.dto.AuthenticationResponse;
import com.flawden.TaskManagerAPI.dto.user.Login;
import com.flawden.TaskManagerAPI.dto.user.Register;
import com.flawden.TaskManagerAPI.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthControllerImpl implements AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody Register register) {
        return ResponseEntity.ok(authService.register(register));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody Login login) {
        return ResponseEntity.ok(authService.login(login));
    }
}
