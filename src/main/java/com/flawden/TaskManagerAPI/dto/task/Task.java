package com.flawden.TaskManagerAPI.dto.task;

import com.flawden.TaskManagerAPI.dto.Comment;
import com.flawden.TaskManagerAPI.dto.user.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Объект, представляющий задачу в системе")
public class Task {

    @Schema(description = "Уникальный идентификатор задачи", example = "1")
    private Long id;

    @Schema(description = "Название задачи", example = "Задача 1")
    private String title;

    @Schema(description = "Описание задачи", example = "Описание задачи 1")
    private String description;

    @Schema(description = "Статус задачи", allowableValues = {"TODO", "IN_PROGRESS", "DONE"}, example = "TODO")
    private String status;

    @Schema(description = "Приоритет задачи", allowableValues = {"LOW", "MEDIUM", "HIGH"}, example = "MEDIUM")
    private String priority;

    @Schema(description = "Список исполнителей задачи")
    private List<User> executors;

    @Schema(description = "Список комментариев к задаче")
    private List<Comment> comments;

}
