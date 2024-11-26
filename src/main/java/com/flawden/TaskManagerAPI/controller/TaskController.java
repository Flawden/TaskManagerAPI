package com.flawden.TaskManagerAPI.controller;

import com.flawden.TaskManagerAPI.dto.task.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface TaskController {

    ResponseEntity<List<Task>> getAllTasks(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "limit", required = false) Integer limit);
    ResponseEntity<Task> getTaskById(@PathVariable Long id);
    ResponseEntity<Task> addTask(@RequestBody Task task);
    ResponseEntity<HttpStatus> updateTask(@RequestBody Task task, @PathVariable Long taskId);
    ResponseEntity<HttpStatus> deleteTask(@PathVariable Long id);
    ResponseEntity<Task> getTaskByName(@PathVariable String name);

}

