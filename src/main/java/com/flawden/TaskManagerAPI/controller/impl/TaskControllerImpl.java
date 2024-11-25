package com.flawden.TaskManagerAPI.controller.impl;

import com.flawden.TaskManagerAPI.controller.TaskController;
import com.flawden.TaskManagerAPI.dto.task.Task;
import com.flawden.TaskManagerAPI.dto.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
public class TaskControllerImpl implements TaskController {

    @GetMapping
    @Override
    public ResponseEntity<List<Task>> getAllTasks(Long page) {
        return null;
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Task> getTaskById(Long id) {
        return null;
    }

    @PostMapping
    @Override
    public ResponseEntity<Task> addTask(Task task) {
        return null;
    }

    @PatchMapping
    @Override
    public ResponseEntity<Task> updateTask(Task task) {
        return null;
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Task> deleteTask(Long id) {
        return null;
    }

    @GetMapping("/user/{username}")
    @Override
    public ResponseEntity<Task> getTaskByName(String name) {
        return null;
    }

    @GetMapping("/user")
    @Override
    public ResponseEntity<Task> getTaskByUser(User user) {
        return null;
    }
}
