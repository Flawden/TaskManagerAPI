package com.flawden.TaskManagerAPI.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Текст комментария не может быть пустым")
    private String text;

    @ManyToOne
    @NotNull(message = "Автор комментария не может быть пустым")
    private UserEntity author;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull(message = "Задача не может быть пустой")
    private TaskEntity task;
}
