package com.flawden.TaskManagerAPI.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Объект для передачи данных для аутентификации пользователя")
public class Login {

    @Schema(description = "Имя пользователя для аутентификации", example = "user@mail.ru")
    private String username;

    @Schema(description = "Пароль пользователя для аутентификации", example = "password123")
    private String password;
}
