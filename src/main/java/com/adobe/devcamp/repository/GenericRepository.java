package com.adobe.devcamp.repository;

import java.util.List;
import java.util.Optional;

public interface GenericRepository<T> {
    T save(T entity);

    Optional<T> findById(String id);

    List<T> findAll();

    void deleteById(String id);
}
