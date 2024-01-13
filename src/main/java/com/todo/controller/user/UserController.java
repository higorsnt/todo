package com.todo.controller.user;

import com.todo.business.user.UserService;
import com.todo.dto.user.UserCreateDto;
import com.todo.dto.user.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Save a user")
    @ApiResponse(
            responseCode = "201",
            description = "Saved user",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = UserDto.class))})
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto save(@Valid @RequestBody UserCreateDto userDto) {
        return userService.create(userDto);
    }
}
