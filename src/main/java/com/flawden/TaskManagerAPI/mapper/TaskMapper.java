package com.flawden.TaskManagerAPI.mapper;

import com.flawden.TaskManagerAPI.dto.task.Task;
import com.flawden.TaskManagerAPI.model.TaskEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    Task mapTaskEntityToTask(TaskEntity taskEntity);

    TaskEntity mapTaskToTaskEntity(Task task);

}
