package com.flawden.TaskManagerAPI.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Объект для передачи данных для регистрации нового пользователя")
public class Register {

    @Schema(description = "Имя пользователя для регистрации", example = "user@mail.ru")
    private String username;

    @Schema(description = "Пароль пользователя для регистрации", example = "password123")
    private String password;

    @Schema(description = "Имя пользователя", example = "John")
    private String firstName;

    @Schema(description = "Фамилия пользователя", example = "Doe")
    private String lastName;

    @Schema(description = "Роль пользователя в системе", example = "USER")
    private String role;
}
