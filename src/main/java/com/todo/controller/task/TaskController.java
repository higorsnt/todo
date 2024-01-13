package com.todo.controller.task;

import com.todo.business.auth.JwtHelper;
import com.todo.business.task.TaskService;
import com.todo.dto.task.TaskCreateDto;
import com.todo.dto.task.TaskDto;
import com.todo.dto.task.TaskUpdateDto;
import com.todo.dto.user.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @Operation(summary = "Save a task to an user")
    @ApiResponse(
            responseCode = "201",
            description = "Saved task",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = TaskDto.class))})
    @PostMapping("/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public TaskDto save(@Valid @RequestBody TaskCreateDto taskDto, @PathVariable("userId") Long userID) {
        return taskService.create(taskDto, userID);
    }

    @Operation(summary = "List all tasks of a user")
    @ApiResponse(
            responseCode = "200",
            description = "All user tasks",
            content = {@Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = TaskDto.class)))})
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TaskDto> findAll(@RequestHeader("Authorization") String authHeader) {
        String token = authHeader.substring(7);
        String email = JwtHelper.extractUsername(token);
        return taskService.findAll(email);
    }

    @Operation(summary = "Updates task information")
    @ApiResponse(
            responseCode = "200",
            description = "Updated task",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = TaskDto.class))})
    @PutMapping("/{taskId}")
    @ResponseStatus(HttpStatus.OK)
    public TaskDto update(@Valid @RequestBody TaskUpdateDto taskDto, @PathVariable("taskId") Long taskId) {
        return taskService.update(taskDto, taskId);
    }

}
