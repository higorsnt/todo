package com.todo.business.task;

import com.todo.dto.task.TaskCreateDto;
import com.todo.dto.task.TaskDto;
import com.todo.dto.task.TaskUpdateDto;

import java.util.List;

public interface TaskService {

    TaskDto create(TaskCreateDto taskDto, Long userId);

    TaskDto update(TaskUpdateDto taskDto, Long taskId);

    List<TaskDto> findAll(String email);

}
