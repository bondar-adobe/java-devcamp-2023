package com.adobe.devcamp.dao;

import com.adobe.devcamp.model.Advertiser;
import com.adobe.devcamp.model.Campaign;
import com.adobe.devcamp.model.Publisher;
import com.adobe.devcamp.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

@Repository
public class AdvertisingDao<T> {
    /*
        Create - INSERT
        Read - SELECT
        Update - UPDATE
        Delete - DELETE

     */

    private final Logger logger = LoggerFactory.getLogger(AdvertisingDao.class);
    private final Connection connection;

    private static final Map<Class, String> TABLES = new HashMap<>();

    static {
        TABLES.put(User.class, "users");
        TABLES.put(Advertiser.class, "advertisers");
        TABLES.put(Publisher.class, "publishers");
        TABLES.put(Campaign.class, "campaigns");
    }

    public AdvertisingDao(DataSource dataSource) throws SQLException {
        this.connection = dataSource.getConnection();
    }

    public Map<Integer, String> selectAll(Class<T> clazz) {
        Map<Integer, String> all = new HashMap<>();

        final String query = "SELECT * FROM " + TABLES.get(clazz);

        try {
            final Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                all.put(resultSet.getInt(1), resultSet.getString(2));
            }
        } catch (SQLException ex) {
            logger.error("Query {} failed because {}", query, ex.getMessage(), ex);
        }

        return all;
    }
    
    //TODO: Implement this method
    public String selectById(Class<T> clazz, int id) {
        
         //DELETE THIS LINE WHEN YOU START IMPLEMENTING THIS METHOD
        return null;
    }
}
