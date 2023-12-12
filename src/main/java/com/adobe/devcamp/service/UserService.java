package com.adobe.devcamp.service;

import com.adobe.devcamp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // This service should provide all the necessary methods for managing users.
    // This includes:
    //    1. Creating a new user
    //    2. Fetching a user by id from the database
    //    3. Fetching all users
    //    4. Deleting a user

}
