package com.todo.business.user;

import com.todo.dto.user.UserCreateDto;
import com.todo.dto.user.UserDto;
import com.todo.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
class UserServiceImpl implements UserService {

    private final UserRepository repository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDto create(UserCreateDto userDto) {
        String encodedPassword = passwordEncoder.encode(userDto.password());
        User user = new User(userDto.name(), userDto.email(), encodedPassword);
        user = repository.save(user);
        return new UserDto(user);
    }

    @Override
    public User findById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public User findByEmail(String email) {
        return repository.findByEmail(email).orElseThrow();
    }
}
