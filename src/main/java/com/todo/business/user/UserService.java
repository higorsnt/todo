package com.todo.business.user;

import com.todo.dto.user.UserCreateDto;
import com.todo.dto.user.UserDto;
import com.todo.entity.user.User;

public interface UserService {

    UserDto create(UserCreateDto userDto);

    User findById(Long id);

    User findByEmail(String email);

}
