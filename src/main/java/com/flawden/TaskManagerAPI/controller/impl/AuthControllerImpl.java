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

/**
 * Контроллер для аутентификации и регистрации пользователей.
 * <p>
 * Этот контроллер обрабатывает запросы на регистрацию новых пользователей и аутентификацию существующих пользователей.
 * </p>
 */
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthControllerImpl implements AuthController {

    private final AuthService authService;

    /**
     * Регистрация нового пользователя.
     * <p>
     * Метод позволяет пользователю зарегистрироваться, передав необходимые данные для регистрации в теле запроса.
     * </p>
     *
     * @param register Объект, содержащий данные для регистрации (например, имя, email, пароль).
     * @return Ответ с токеном аутентификации после успешной регистрации.
     */
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody Register register) {
        return ResponseEntity.ok(authService.register(register));
    }

    /**
     * Аутентификация пользователя.
     * <p>
     * Метод позволяет пользователю войти в систему, предоставив данные для входа (например, email и пароль).
     * </p>
     *
     * @param login Объект, содержащий данные для аутентификации (например, email, пароль).
     * @return Ответ с токеном аутентификации после успешного входа.
     */
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody Login login) {
        return ResponseEntity.ok(authService.login(login));
    }
}
