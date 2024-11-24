package com.flawden.TaskManagerAPI.controller.impl;

import com.flawden.TaskManagerAPI.controller.TaskController;
import com.flawden.TaskManagerAPI.dto.task.Task;
import com.flawden.TaskManagerAPI.dto.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
public class TaskControllerImpl implements TaskController {

    @Override
    public ResponseEntity<List<Task>> getAllTasks() {
        return null;
    }

    @Override
    public ResponseEntity<List<Task>> getTasksWithPagination(int page) {
        return null;
    }

    @Override
    public ResponseEntity<Task> getTaskById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Task> addTask(Task task) {
        return null;
    }

    @Override
    public ResponseEntity<Task> updateTask(Task task) {
        return null;
    }

    @Override
    public ResponseEntity<Task> deleteTask(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Task> getTaskByName(String name) {
        return null;
    }

    @Override
    public ResponseEntity<Task> getTaskByUser(User user) {
        return null;
    }
}
