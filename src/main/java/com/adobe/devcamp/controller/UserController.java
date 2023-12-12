package com.adobe.devcamp.controller;

import com.adobe.devcamp.dto.UserDTO;
import com.adobe.devcamp.model.Gender;
import com.adobe.devcamp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/users",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        // TODO: implement this
        return userDTO;
    }

    @GetMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO> getAllUsers() {
        // TODO: implement this
        return List.of(new UserDTO("someId", "bondar@adobe.com", Gender.FEMALE, 26, Collections.emptyList()));
//        return Collections.emptyList();
    }

    // TODO: add functionality for:
    //      - retrieving a user by id
    //      - deleting a user
}

