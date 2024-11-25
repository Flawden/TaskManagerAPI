package com.flawden.TaskManagerAPI.service.impl;

import com.flawden.TaskManagerAPI.dto.task.Task;
import com.flawden.TaskManagerAPI.dto.user.User;
import com.flawden.TaskManagerAPI.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    @Override
    public List<Task> getAllTasks() {
        return List.of();
    }

    @Override
    public List<Task> getTasksWithPagination(Long page) {
        return List.of();
    }

    @Override
    public Task getTaskById(Long id) {
        return null;
    }

    @Override
    public Task addTask(Task task) {
        return null;
    }

    @Override
    public Task updateTask(Task task) {
        return null;
    }

    @Override
    public Task deleteTask(Long id) {
        return null;
    }

    @Override
    public Task getTaskByName(String name) {
        return null;
    }

    @Override
    public Task getTaskByUser(User user) {
        return null;
    }
}
