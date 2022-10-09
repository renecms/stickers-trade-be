package com.renecms.stickerstradebe.controller;

import com.renecms.stickerstradebe.dto.UserDto;
import com.renecms.stickerstradebe.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {
    public UserService service;

    @GetMapping("/user/{id}")
    public UserDto get(@PathVariable Integer id) {
        return service.getUsers(id);
    }

    @GetMapping("/user")
    public List<UserDto> getAll() {
        return service.getAllUsers();
    }

    @PostMapping("/user")
    public UserDto save(@Valid @RequestBody UserDto userDto) {
        return service.createUser(userDto);
    }

    @PutMapping("/user/{id}")
    public UserDto update(@PathVariable Integer id, @Valid @RequestBody UserDto userDto) {
        userDto.setId(id);
        return service.updateUser(userDto);
    }
}
