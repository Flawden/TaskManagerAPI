package com.flawden.TaskManagerAPI.service;

import com.flawden.TaskManagerAPI.dto.task.Task;
import com.flawden.TaskManagerAPI.dto.user.User;

import java.util.List;

public interface TaskService {

    List<Task> getAllTasks();

    List<Task> getTasksWithPagination(int page);

    Task getTaskById(Long id);

    Task addTask(Task task);

    Task updateTask(Task task);

    Task deleteTask(Long id);

    Task getTaskByName(String name);

    Task getTaskByUser(User user);

}
