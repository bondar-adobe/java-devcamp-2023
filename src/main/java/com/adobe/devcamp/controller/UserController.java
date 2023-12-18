package com.adobe.devcamp.controller;

import com.adobe.devcamp.dto.UserDTO;
import com.adobe.devcamp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

@RestController
public final class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/users",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(CREATED)
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @GetMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(path = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public UserDTO getUserById(@PathVariable("id") String id) {
        return userService.getUserById(id);
    }

    @DeleteMapping(path = "/users/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteUserById(@PathVariable("id") String id) {
        userService.deleteUserById(id);
    }

    @GetMapping(path = "/users/custom", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public List<UserDTO> getAllFemaleUsersYoungerThan30() {
        return userService.getAllFemaleUsersYoungerThan30();
    }
}

