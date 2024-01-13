package com.todo.business.task;

import com.todo.business.user.UserService;
import com.todo.dto.task.TaskCreateDto;
import com.todo.dto.task.TaskDto;
import com.todo.dto.task.TaskUpdateDto;
import com.todo.entity.task.Task;
import com.todo.entity.user.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class TaskServiceImpl implements TaskService {

    private final UserService userService;

    private final TaskRepository repository;

    @Autowired
    public TaskServiceImpl(UserService userService, TaskRepository repository) {
        this.userService = userService;
        this.repository = repository;
    }

    @Override
    public TaskDto create(TaskCreateDto taskDto, Long userId) {
        User user = userService.findById(userId);
        Task task = new Task(taskDto.desc(), taskDto.estimatedAt(), taskDto.doneAt(), user);
        task = repository.save(task);
        return new TaskDto(task);
    }

    @Override
    @Transactional
    public TaskDto update(TaskUpdateDto taskDto, Long taskId) {
        Task task = repository.findById(taskId).orElseThrow();
        task.setDesc(taskDto.desc());

        if (taskDto.doneAt() != null) {
            task.setDoneAt(taskDto.doneAt());
        }

        return new TaskDto(task);
    }

    @Override
    public List<TaskDto> findAll(String email) {
        User user = userService.findByEmail(email);
        return repository.findAllByUser(user).stream().map(TaskDto::new).toList();
    }
}
