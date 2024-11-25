package com.flawden.TaskManagerAPI.controller;

import com.flawden.TaskManagerAPI.dto.task.Task;
import com.flawden.TaskManagerAPI.dto.user.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface TaskController {

    ResponseEntity<List<Task>> getAllTasks(@RequestParam(value = "page", required = false) Long page);
    ResponseEntity<Task> getTaskById(@RequestParam Long id);
    ResponseEntity<Task> addTask(@RequestBody Task task);
    ResponseEntity<Task> updateTask(@RequestBody Task task);
    ResponseEntity<Task> deleteTask(@RequestParam Long id);
    ResponseEntity<Task> getTaskByName(@RequestParam String name);
    ResponseEntity<Task> getTaskByUser(@RequestBody User user);

}

