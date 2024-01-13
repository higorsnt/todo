package com.todo.controller.auth;

import com.todo.business.auth.JwtHelper;
import com.todo.dto.auth.LoginRequestDto;
import com.todo.dto.auth.LoginResponseDto;
import com.todo.dto.user.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class AuthController {

    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Operation(summary = "Login a user")
    @ApiResponse(
            responseCode = "200",
            description = "Login a user",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = LoginRequestDto.class))})
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public LoginResponseDto login(@Valid @RequestBody LoginRequestDto loginRequestDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDto.email(),
                loginRequestDto.password()));
        String token = JwtHelper.generateToken(loginRequestDto.email());
        return new LoginResponseDto(loginRequestDto.email(), token);
    }
}
