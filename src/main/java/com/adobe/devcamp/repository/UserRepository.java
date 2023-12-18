package com.adobe.devcamp.repository;

import com.adobe.devcamp.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserRepository implements GenericRepository<User> {
    private final List<User> storedUsers;

    public UserRepository() {
        this.storedUsers = new ArrayList<>();
    }

    @Override
    public User save(User entity) {
        storedUsers.add(entity);
        return entity;
    }

    @Override
    public Optional<User> findById(String id) {
        for (User user : storedUsers) {
            if (user.getId().equals(id)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return storedUsers;
    }

    @Override
    public void deleteById(String id) {
        // TODO: implement this
    }
}
