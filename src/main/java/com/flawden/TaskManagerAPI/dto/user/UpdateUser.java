package com.flawden.TaskManagerAPI.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Объект для передачи данных для обновления пользователя")
public class UpdateUser {

    @Schema(description = "Имя пользователя", example = "John")
    private String firstName;

    @Schema(description = "Фамилия пользователя", example = "Doe")
    private String lastName;

    @Schema(description = "Электронная почта пользователя", example = "johndoe@example.com")
    private String email;
}
