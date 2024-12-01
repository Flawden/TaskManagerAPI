package com.flawden.TaskManagerAPI.mapper;

import com.flawden.TaskManagerAPI.dto.task.Priority;
import com.flawden.TaskManagerAPI.dto.task.Status;
import com.flawden.TaskManagerAPI.dto.task.Task;
import com.flawden.TaskManagerAPI.model.TaskEntity;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.assertj.core.api.Assertions.assertThat;

public class TaskMapperTest {

    private final TaskMapper taskMapper = Mappers.getMapper(TaskMapper.class);

    @Test
    void shouldMapTaskEntityToTask() {
        // Given
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setId(1L);
        taskEntity.setTitle("Test Task");
        taskEntity.setDescription("Task description");
        taskEntity.setStatus(Status.COMPLETED);
        taskEntity.setPriority(Priority.HIGH);

        Task task = taskMapper.mapTaskEntityToTask(taskEntity);

        // Then
        assertThat(task.getId()).isEqualTo(1L);
        assertThat(task.getTitle()).isEqualTo("Test Task");
        assertThat(task.getDescription()).isEqualTo("Task description");
        assertThat(task.getStatus()).isEqualTo("COMPLETED");
        assertThat(task.getPriority()).isEqualTo("HIGH");
    }

    @Test
    void shouldMapTaskToTaskEntity() {
        // Given
        Task task = new Task();
        task.setId(1L);
        task.setTitle("Test Task");
        task.setDescription("Task description");
        task.setStatus("COMPLETED");
        task.setPriority("HIGH");

        // When
        TaskEntity taskEntity = taskMapper.mapTaskToTaskEntity(task);

        // Then
        assertThat(taskEntity.getId()).isEqualTo(1L);
        assertThat(taskEntity.getTitle()).isEqualTo("Test Task");
        assertThat(taskEntity.getDescription()).isEqualTo("Task description");
        assertThat(taskEntity.getStatus()).isEqualTo(Status.COMPLETED);
        assertThat(taskEntity.getPriority()).isEqualTo(Priority.HIGH);
    }
}


