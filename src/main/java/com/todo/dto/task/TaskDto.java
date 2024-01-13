package com.todo.dto.task;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.todo.entity.task.Task;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

public record TaskDto(
        Long id,

        @Schema(description = "Task description")
        String desc,


        @JsonFormat(pattern = "dd/MM/yyyy")
        @Schema(description = "Task start date", example = "10/01/2024")
        LocalDate estimatedAt,

        @JsonFormat(pattern = "dd/MM/yyyy")
        @Schema(description = "Task end date", example = "11/01/2024")
        LocalDate doneAt
) {
    public TaskDto(Task task) {
        this(
                task.getId(),
                task.getDesc(),
                task.getEstimatedAt(),
                task.getDoneAt()
        );
    }
}
