package com.adobe.devcamp.repository;

import com.adobe.devcamp.model.Advertiser;
import com.adobe.devcamp.model.Campaign;
import com.adobe.devcamp.model.Publisher;
import com.adobe.devcamp.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Repository
public class AdvertisingRepository<T> {
    /*
        Create - INSERT
        Read - SELECT
        Update - UPDATE
        Delete - DELETE

     */

    private final Logger logger = LoggerFactory.getLogger(AdvertisingRepository.class);
    private final Connection connection;

    private static final Map<Class, String> TABLES = new HashMap<>();

    static {
        TABLES.put(User.class, "users");
        TABLES.put(Advertiser.class, "advertisers");
        TABLES.put(Publisher.class, "publishers");
        TABLES.put(Campaign.class, "campaigns");
    }

    public AdvertisingRepository(DataSource dataSource) throws SQLException {
        this.connection = dataSource.getConnection();
    }
    
     //TODO: Implement this method
     public Map<Integer, String> selectAll(Class<T> clazz) {
         
         //DELETE THIS LINE WHEN YOU START IMPLEMENTING THIS METHOD
         return null;
    }
    
    //TODO: Implement this method
    public String selectById(Class<T> clazz, int id) {
        
         //DELETE THIS LINE WHEN YOU START IMPLEMENTING THIS METHOD
        return null;
    }
}
