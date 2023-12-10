package com.adobe.devcamp.service;

import com.adobe.devcamp.repository.AdvertisingRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AdvertisingService<T> {
    private static final Logger logger = LoggerFactory.getLogger(AdvertisingService.class);
    private final AdvertisingRepository<T> repository;
    private final ObjectMapper objectMapper;

    public AdvertisingService(AdvertisingRepository<T> dao, ObjectMapper objectMapper) {
        this.repository = dao;
        this.objectMapper = objectMapper;
    }

    //TODO: Implement this method
    public Map<Integer, T> selectAll(Class<T> clazz) {

        //DELETE THIS LINE WHEN YOU START IMPLEMENTING THIS METHOD
        return null;
    }

    //TODO: Implement this method
    public T selectById(Class<T> clazz, int id) {

        //DELETE THIS LINE WHEN YOU START IMPLEMENTING THIS METHOD
        return null;
    }
}
