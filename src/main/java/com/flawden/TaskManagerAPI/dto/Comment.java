package com.flawden.TaskManagerAPI.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Комментарий, привязанный к задаче")
public class Comment {

    @Schema(description = "Уникальный идентификатор комментария", example = "1")
    private Long id;

    @Schema(description = "Текст комментария", example = "Это важное замечание к задаче.")
    private String text;

    @Schema(description = "Идентификатор автора комментария", example = "123")
    private Long author;

    @Schema(description = "Идентификатор задачи, к которой относится комментарий", example = "456")
    private Long task;

}
