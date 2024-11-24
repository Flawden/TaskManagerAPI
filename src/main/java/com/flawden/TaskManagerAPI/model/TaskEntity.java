package com.flawden.TaskManagerAPI.model;

import com.flawden.TaskManagerAPI.dto.task.Priority;
import com.flawden.TaskManagerAPI.dto.task.Status;
import jakarta.persistence.*;
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

    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @ManyToMany
    private List<UserEntity> executors;

    @OneToMany(mappedBy = "task")
    private List<CommentEntity> commentEntities;
}
