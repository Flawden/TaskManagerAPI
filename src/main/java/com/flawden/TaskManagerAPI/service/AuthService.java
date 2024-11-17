package com.flawden.TaskManagerAPI.service;

import com.flawden.TaskManagerAPI.dto.AuthenticationResponse;
import com.flawden.TaskManagerAPI.dto.Login;
import com.flawden.TaskManagerAPI.dto.Register;

public interface AuthService {

    AuthenticationResponse register(Register register);

    AuthenticationResponse login(Login login);

}
