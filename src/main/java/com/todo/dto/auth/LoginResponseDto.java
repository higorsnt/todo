package com.todo.dto.auth;

import io.swagger.v3.oas.annotations.media.Schema;

public record LoginResponseDto(
        @Schema(description = "User email for authentication", example = "example@mail.com")
        String email,

        @Schema(description = "Authentication token")
        String token) {
}
