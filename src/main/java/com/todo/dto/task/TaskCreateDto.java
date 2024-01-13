package com.todo.dto.task;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public record TaskCreateDto(
        @NotNull
        @Schema(description = "Task description")
        String desc,

        @NotNull
        @PastOrPresent
        @JsonFormat(pattern = "dd/MM/yyyy")
        @Schema(description = "Task start date", example = "10/01/2024")
        LocalDate estimatedAt,

        @JsonFormat(pattern = "dd/MM/yyyy")
        @Schema(description = "Task end date", example = "11/01/2024")
        LocalDate doneAt) {
}
