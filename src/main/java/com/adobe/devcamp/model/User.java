package com.adobe.devcamp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import java.sql.Timestamp;

@Entity
public class User {
    @Id private String id;
    private String email;
    private String gender;
    private int age;
    private String interests;
    private Timestamp createdDate;

    @PrePersist
    public void prePersist() {
        this.createdDate = new Timestamp(System.currentTimeMillis());
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getInterests() {
        return interests;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }
}
