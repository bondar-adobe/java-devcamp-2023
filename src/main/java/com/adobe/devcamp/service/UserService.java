package com.adobe.devcamp.service;

import com.adobe.devcamp.dto.UserDTO;
import com.adobe.devcamp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserService {
    // This service should provide all the necessary methods for managing users.
    // This includes:
    //    1. Creating a new user
    //    2. Fetching a user by id from the database
    //    3. Fetching all users
    //    4. Deleting a user
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO getUserById(String id) {
        return null;
    }

    public List<UserDTO> getAllUsers() {
        return Collections.emptyList();
    }

    public UserDTO createUser(UserDTO userDTO) {
        return userDTO;
    }

}
