package com.flawden.TaskManagerAPI.model;

import com.flawden.TaskManagerAPI.dto.task.Priority;
import com.flawden.TaskManagerAPI.dto.task.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Название задачи не может быть пустым")
    @Size(min = 1, max = 100, message = "Название задачи должно быть от 1 до 100 символов")
    private String title;

    @NotNull(message = "Описание задачи не может быть пустым")
    @Size(min = 1, max = 500, message = "Описание задачи должно быть от 1 до 500 символов")
    private String description;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Статус задачи не может быть пустым")
    private Status status;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Приоритет задачи не может быть пустым")
    private Priority priority;

    @ManyToMany
    @JoinTable(
            name = "task_user",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<UserEntity> executors;

    @OneToMany(mappedBy = "task")
    private List<CommentEntity> comments;
}
