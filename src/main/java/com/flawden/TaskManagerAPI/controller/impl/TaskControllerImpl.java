package com.flawden.TaskManagerAPI.controller.impl;

import com.flawden.TaskManagerAPI.controller.TaskController;
import com.flawden.TaskManagerAPI.dto.task.Task;
import com.flawden.TaskManagerAPI.dto.user.User;
import com.flawden.TaskManagerAPI.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
public class TaskControllerImpl implements TaskController {

    private final TaskService taskService;

    @GetMapping
    @Override
    public ResponseEntity<List<Task>> getAllTasks(Long page) {
        if (page == null) {
            return ResponseEntity.ok(taskService.getAllTasks());
        } else {
            return ResponseEntity.ok(taskService.getTasksWithPagination(page));
        }
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Task> getTaskById(Long id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    @PostMapping
    @Override
    public ResponseEntity<Task> addTask(Task task) {
        return ResponseEntity.ok(taskService.addTask(task));
    }

    @PatchMapping
    @Override
    public ResponseEntity<Task> updateTask(Task task) {
        return ResponseEntity.ok(taskService.updateTask(task));
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Task> deleteTask(Long id) {
        return ResponseEntity.ok(taskService.deleteTask(id));
    }

    @GetMapping("/user/{username}")
    @Override
    public ResponseEntity<Task> getTaskByName(String name) {
        return ResponseEntity.ok(taskService.getTaskByName(name));
    }

    @GetMapping("/user")
    @Override
    public ResponseEntity<Task> getTaskByUser(User user) {
        return ResponseEntity.ok(taskService.getTaskByUser(user));
    }
}
