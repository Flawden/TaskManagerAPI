package com.flawden.TaskManagerAPI.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Представление пользователя в системе")
public class User {

    @Schema(description = "Идентификатор пользователя", example = "1")
    private Long id;

    @Schema(description = "Электронная почта пользователя", example = "johndoe@example.com")
    @Email(message = "Адрес электронной почты не валиден")
    @NotNull(message = "Адрес электронной почты не может быть пустым")
    private String email;

    @Schema(description = "Имя пользователя", example = "John")
    @NotNull(message = "Имя не может быть пустым")
    private String firstName;

    @Schema(description = "Фамилия пользователя", example = "Doe")
    @NotNull(message = "Фамилия не может быть пустой")
    private String lastName;

    @Schema(description = "Роль пользователя в системе", example = "USER")
    @NotNull(message = "Роль не может быть пустой")
    private String role;
}