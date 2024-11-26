package com.flawden.TaskManagerAPI.service;

import com.flawden.TaskManagerAPI.dto.task.Task;

import java.util.List;

public interface TaskService {

    List<Task> getAllTasks();

    List<Task> getTasksWithPagination(Integer page, Integer size);

    Task getTaskById(Long id);

    Task addTask(Task task);

    Task updateTask(Task task, Long taskId);

    void deleteTask(Long id);

    Task getTaskByName(String name);

}
