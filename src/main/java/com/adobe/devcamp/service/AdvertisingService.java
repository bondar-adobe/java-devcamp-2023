package com.adobe.devcamp.service;

import com.adobe.devcamp.dao.AdvertisingDao;
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
    private final AdvertisingDao<T> dao;
    private final ObjectMapper objectMapper;

    public AdvertisingService(AdvertisingDao<T> dao, ObjectMapper objectMapper) {
        this.dao = dao;
        this.objectMapper = objectMapper;
    }

    //select users from db and convert
    //Map<Integer, String> into Map<Integer, User>
    public Map<Integer, T> selectAll(Class<T> clazz){
        final Map<Integer, String> allAsString = dao.selectAll(clazz);
        final Map<Integer, T> all = new HashMap<>();

        for(Map.Entry<Integer, String> entry: allAsString.entrySet()){
            try {
                final T t = objectMapper.readValue(entry.getValue(), clazz);
                all.put(entry.getKey(), t);
            } catch (JsonProcessingException e) {
                logger.error("Object {} couldn't be deserialized", entry.getValue(), e);
            }
        }

        return all;
    }

    public T selectById(Class<T> clazz, int id) {
        final String json = dao.selectById(clazz, id);

        try {
            return objectMapper.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            logger.error("Object {} could not be deserialized", json, e);
        } catch(Exception ex) {
            logger.error("An error occurred");
        }

        return null;
    }
}
