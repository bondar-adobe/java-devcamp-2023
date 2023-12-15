package com.adobe.devcamp.service;

import com.adobe.devcamp.dto.UserDTO;
import com.adobe.devcamp.model.User;
import com.adobe.devcamp.repository.UserRepository;
import com.adobe.devcamp.utils.DTOFactory;
import com.adobe.devcamp.utils.EntityFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private final EntityFactory entityFactory;
    private final DTOFactory dtoFactory;

    @Autowired
    public UserService(UserRepository userRepository, EntityFactory entityFactory, DTOFactory dtoFactory) {
        this.userRepository = userRepository;
        this.entityFactory = entityFactory;
        this.dtoFactory = dtoFactory;
    }

    public UserDTO getUserById(String id) {
        return userRepository.findById(id)
                .map(dtoFactory::userEntityToDTO)
                .orElse(null);
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream().map(dtoFactory::userEntityToDTO)
                .collect(java.util.stream.Collectors.toList());
    }

    public UserDTO createUser(UserDTO userDTO) {
        final User user = entityFactory.userDTOToEntity(userDTO);
        final User savedUser = userRepository.save(user);
        return dtoFactory.userEntityToDTO(savedUser);
    }

    public void deleteUserById(String userId) {
        userRepository.deleteById(userId);
    }

    public List<UserDTO> getAllFemaleUsersYoungerThan30() {
        // TODO(streams + JPA)x: Implement this method
        return null;
    }
}
