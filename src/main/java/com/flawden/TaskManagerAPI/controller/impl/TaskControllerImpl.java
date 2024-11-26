package com.flawden.TaskManagerAPI.controller.impl;

import com.flawden.TaskManagerAPI.controller.TaskController;
import com.flawden.TaskManagerAPI.dto.task.Task;
import com.flawden.TaskManagerAPI.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<List<Task>> getAllTasks(Integer page, Integer limit) {
        if (page == null) {
            return ResponseEntity.ok(taskService.getAllTasks());
        } else {
            return ResponseEntity.ok(taskService.getTasksWithPagination(page, limit));
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

    @PatchMapping("/{id}")
    @Override
    public ResponseEntity<HttpStatus> updateTask(Task task, Long taskId) {
        taskService.updateTask(task, taskId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<HttpStatus> deleteTask(Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user/{username}")
    @Override
    public ResponseEntity<Task> getTaskByName(String name) {
        return ResponseEntity.ok(taskService.getTaskByName(name));
    }

}
