package com.flawden.TaskManagerAPI.repository;

import com.flawden.TaskManagerAPI.model.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
}
