package com.flawden.TaskManagerAPI.controller;

import com.flawden.TaskManagerAPI.controller.impl.AuthControllerImpl;
import com.flawden.TaskManagerAPI.dto.AuthenticationResponse;
import com.flawden.TaskManagerAPI.dto.user.Login;
import com.flawden.TaskManagerAPI.dto.user.Register;
import com.flawden.TaskManagerAPI.service.AuthService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class AuthControllerImplTest {

    @Mock
    private AuthService authService;

    @InjectMocks
    private AuthControllerImpl authController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldRegisterUserSuccessfully() {
        Register registerRequest = new Register("john@example.com", "password123", "John", "Doe", "USER");
        AuthenticationResponse expectedResponse = new AuthenticationResponse("jwt-token");

        when(authService.register(registerRequest)).thenReturn(expectedResponse);

        ResponseEntity<AuthenticationResponse> response = authController.register(registerRequest);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(expectedResponse, response.getBody());
        verify(authService).register(registerRequest);
    }

    @Test
    void shouldAuthenticateUserSuccessfully() {
        // Given
        Login loginRequest = new Login("john@example.com", "password123");
        AuthenticationResponse expectedResponse = new AuthenticationResponse("jwt-token");

        when(authService.login(loginRequest)).thenReturn(expectedResponse);

        // When
        ResponseEntity<AuthenticationResponse> response = authController.login(loginRequest);

        // Then
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(expectedResponse, response.getBody());
        verify(authService).login(loginRequest);
    }
}

