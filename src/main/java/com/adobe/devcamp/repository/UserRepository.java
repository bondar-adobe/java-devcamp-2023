package com.adobe.devcamp.repository;

import com.adobe.devcamp.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        return Optional.empty();
    }

    @Override
    public List<UserDTO> findAll() {
        return null;
    }

    @Override
    public void deleteById(String id) {
    }
}
