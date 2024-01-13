package com.todo.dto.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LoginRequestDto(
        @NotNull
        @NotBlank
        @Email
        @Schema(description = "User email for authentication", example = "example@mail.com")
        String email,

        @NotNull
        @NotBlank
        @Schema(description = "User password")
        String password) {
}
