package com.flawden.TaskManagerAPI.controller;

import com.flawden.TaskManagerAPI.dto.AuthenticationResponse;
import com.flawden.TaskManagerAPI.dto.user.Login;
import com.flawden.TaskManagerAPI.dto.user.Register;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthController {

    ResponseEntity<AuthenticationResponse> register(@RequestBody Register register);

    ResponseEntity<AuthenticationResponse> login(@RequestBody Login login);

}
