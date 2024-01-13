package com.todo.dto.user;

import com.todo.entity.user.User;
import io.swagger.v3.oas.annotations.media.Schema;

public record UserDto(
        Long id,
        @Schema(description = "User name", example = "João") String name,
        @Schema(description = "User password") String email
) {
    public UserDto(User user) {
        this(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }
}
