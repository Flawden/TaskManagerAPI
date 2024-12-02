package com.flawden.TaskManagerAPI.controller;

import com.flawden.TaskManagerAPI.dto.AuthenticationResponse;
import com.flawden.TaskManagerAPI.dto.user.Login;
import com.flawden.TaskManagerAPI.dto.user.Register;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Контроллер аутентификации и регистрации пользователей.
 * <p>
 * Этот контроллер предоставляет два метода для регистрации нового пользователя и для входа
 * в систему с использованием учетных данных. Оба метода возвращают объект с информацией об
 * аутентификации, например, токен доступа.
 * </p>
 */
public interface AuthController {

    /**
     * Регистрация нового пользователя.
     * <p>
     * Этот метод обрабатывает запрос на регистрацию нового пользователя. После успешной регистрации
     * возвращается объект {@link AuthenticationResponse} с токеном доступа, который может быть использован
     * для последующих аутентификаций.
     * </p>
     *
     * @param register объект {@link Register}, содержащий данные для регистрации нового пользователя.
     * @return объект {@link AuthenticationResponse} с токеном аутентификации.
     */
    ResponseEntity<AuthenticationResponse> register(@RequestBody Register register);

    /**
     * Вход в систему пользователя.
     * <p>
     * Этот метод обрабатывает запрос на вход в систему с использованием учетных данных. После успешного входа
     * возвращается объект {@link AuthenticationResponse} с токеном доступа, который может быть использован
     * для последующих аутентификаций.
     * </p>
     *
     * @param login объект {@link Login}, содержащий данные для входа пользователя в систему.
     * @return объект {@link AuthenticationResponse} с токеном аутентификации.
     */
    ResponseEntity<AuthenticationResponse> login(@RequestBody Login login);

}
