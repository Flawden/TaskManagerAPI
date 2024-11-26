package com.flawden.TaskManagerAPI.service.impl;

import com.flawden.TaskManagerAPI.dto.task.Priority;
import com.flawden.TaskManagerAPI.dto.task.Status;
import com.flawden.TaskManagerAPI.dto.task.Task;
import com.flawden.TaskManagerAPI.exception.TaskNotFoundException;
import com.flawden.TaskManagerAPI.mapper.TaskMapper;
import com.flawden.TaskManagerAPI.model.TaskEntity;
import com.flawden.TaskManagerAPI.repository.TaskRepository;
import com.flawden.TaskManagerAPI.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll().stream()
                .map(this::mapTaskEntityToTask)
                .collect(Collectors.toList());
    }

    @Override
    public List<Task> getTasksWithPagination(Integer page, Integer size) {
        return taskRepository.findAll().stream()
                .map(this::mapTaskEntityToTask)
                .collect(Collectors.toList());
    }

    private Task mapTaskEntityToTask(TaskEntity taskEntity) {
        return taskMapper.mapTaskEntityToTask(taskEntity);
    }

    @Override
    public Task getTaskById(Long id) {
        return taskMapper.mapTaskEntityToTask(taskRepository.findById(id).orElseThrow(TaskNotFoundException::new));
    }

    @Override
    public Task addTask(Task task) {
        return taskMapper.mapTaskEntityToTask(taskRepository.save(taskMapper.mapTaskToTaskEntity(task)));
    }

    @Override
    public Task updateTask(Task task, Long taskId) {
        TaskEntity updatableTask = taskRepository.findById(taskId).orElseThrow(TaskNotFoundException::new);
        updatableTask.setTitle(task.getTitle());
        updatableTask.setDescription(task.getDescription());
        updatableTask.setStatus(Status.valueOf(task.getStatus()));
        updatableTask.setPriority(Priority.valueOf(task.getPriority()));
        return taskMapper.mapTaskEntityToTask(taskRepository.save(updatableTask));
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Task getTaskByName(String name) {
        return taskMapper.mapTaskEntityToTask(taskRepository.findTaskEntitiesByTitle(name).orElseThrow(TaskNotFoundException::new));
    }

}
