package com.flawden.TaskManagerAPI.controller;

import com.flawden.TaskManagerAPI.dto.task.Task;
import com.flawden.TaskManagerAPI.dto.user.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TaskController {

    ResponseEntity<List<Task>> getAllTasks();
    ResponseEntity<List<Task>> getTasksWithPagination(int page);
    ResponseEntity<Task> getTaskById(Long id);
    ResponseEntity<Task> addTask(Task task);
    ResponseEntity<Task> updateTask(Task task);
    ResponseEntity<Task> deleteTask(Long id);
    ResponseEntity<Task> getTaskByName(String name);
    ResponseEntity<Task> getTaskByUser(User user);

}

