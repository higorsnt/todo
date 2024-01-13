package com.todo.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record UserCreateDto(
        @NotNull
        @Schema(description = "User name", example = "João")
        String name,

        @NotNull
        @Email
        @Schema(description = "User email", example = "example@mail.com")
        String email,

        @NotNull
        @Schema(description = "User password")
        String password
) {
}
