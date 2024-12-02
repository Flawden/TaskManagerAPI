package com.flawden.TaskManagerAPI.controller;

import com.flawden.TaskManagerAPI.dto.user.UpdateUser;
import com.flawden.TaskManagerAPI.dto.user.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Контроллер для работы с пользователями.
 * <p>
 * Этот контроллер предоставляет методы для получения, обновления, удаления пользователей,
 * а также для поиска пользователей по имени пользователя и получения всех пользователей с пагинацией.
 * </p>
 */
public interface UserController {

    /**
     * Получение списка всех пользователей с возможностью пагинации.
     * <p>
     * Этот метод позволяет получить список всех пользователей с пагинацией. Параметры {@code page} и {@code limit}
     * используются для ограничения количества возвращаемых пользователей. Если параметры не указаны,
     * то количество пользователей по умолчанию будет равно 5.
     * </p>
     *
     * @param page  номер страницы (опционально).
     * @param limit количество пользователей на странице (опционально, по умолчанию 5).
     * @return список пользователей с учетом пагинации.
     */
    ResponseEntity<List<User>> getAllUsers(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "limit", required = false) Integer limit);

    /**
     * Получение пользователя по его ID.
     * <p>
     * Этот метод возвращает пользователя с указанным идентификатором.
     * </p>
     *
     * @param id идентификатор пользователя.
     * @return пользователь с заданным ID.
     */
    ResponseEntity<User> getUserById(@PathVariable Long id);

    /**
     * Обновление данных пользователя.
     * <p>
     * Этот метод обрабатывает запрос на обновление данных пользователя с заданным ID.
     * </p>
     *
     * @param user   объект {@link UpdateUser}, содержащий обновленные данные пользователя.
     * @param userId идентификатор пользователя, которого необходимо обновить.
     * @return статус выполнения операции.
     */
    ResponseEntity<HttpStatus> updateUser(@RequestBody UpdateUser user, @PathVariable Long userId);

    /**
     * Удаление пользователя по его ID.
     * <p>
     * Этот метод удаляет пользователя с заданным идентификатором.
     * </p>
     *
     * @param id идентификатор пользователя.
     * @return статус выполнения операции.
     */
    ResponseEntity<HttpStatus> deleteUser(@PathVariable Long id);

    /**
     * Получение пользователя по имени пользователя.
     * <p>
     * Этот метод возвращает пользователя с указанным именем пользователя.
     * </p>
     *
     * @param username имя пользователя.
     * @return пользователь с заданным именем.
     */
    ResponseEntity<User> getUserByUsername(@PathVariable String username);

}
