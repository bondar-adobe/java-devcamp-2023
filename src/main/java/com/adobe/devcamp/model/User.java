package com.adobe.devcamp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id private int id;
    private String email;
    private String gender;
    private int age;
    private String interests;
}
