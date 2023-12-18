package com.adobe.devcamp.repository;

import com.adobe.devcamp.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// TODOs: - unmock this repository
//        - define some JPA queries
//        - what's Optional?

@Component
public class UserRepository implements GenericRepository<UserDTO> {
    private List<UserDTO> storedUsers;

    public UserRepository() {
        this.storedUsers = new ArrayList<>();
    }

    @Override
    public UserDTO save(UserDTO entity) {
        storedUsers.add(entity);
        return entity;
    }

    @Override
    public Optional<UserDTO> findById(String id) {
        for (UserDTO userDTO : storedUsers) {
            if (userDTO.getId().equals(id)) {
                return Optional.of(userDTO);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<UserDTO> findAll() {
        return storedUsers;
    }

    @Override
    public void deleteById(String id) {
        // TODO: implement this
    }
}
