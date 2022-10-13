package de.sva.bootcamp.devops.springdemo.controller;

import de.sva.bootcamp.devops.springdemo.dto.UserDto;
import de.sva.bootcamp.devops.springdemo.mapper.UserMapper;
import de.sva.bootcamp.devops.springdemo.repository.User;
import de.sva.bootcamp.devops.springdemo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/users")
@RestController
public class UserController {

    private final UserService userService;

    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> findAllUsers() {
        List<User> users = userService.findAllUsers();

        List<UserDto> userDtos = userMapper.toUserDtos(users);

        return ResponseEntity.ok(userDtos);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> findUserById(@PathVariable String userId) {
        Optional<User> optionalUser = userService.findUserById(userId);

        if (optionalUser.isEmpty()) {
            ResponseEntity.notFound().build();
        }

        User user = optionalUser.get();
        UserDto userDto = userMapper.toUserDto(user);
        return ResponseEntity.ok(userDto);
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user) {

        User userToCreate = new User(user.getId(), user.getFirstName(), user.getLastName());
        userToCreate.setNew(true);

        User createdUser = userService.createUser(userToCreate);
        UserDto userDto = userMapper.toUserDto(createdUser);
        return ResponseEntity.ok(userDto);
    }
}
