package com.adobe.devcamp.dto;

import com.adobe.devcamp.model.Domain;
import com.adobe.devcamp.model.Gender;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public final class UserDTO {
    private String id;
    private String email;
    private Gender gender;
    private Integer age;
    private List<Domain> interests;

    @JsonCreator
    public UserDTO(@JsonProperty(value = "id") String id,
                   @JsonProperty(value = "email") String email,
                   @JsonProperty(value = "gender") Gender gender,
                   @JsonProperty(value = "age") Integer age,
                   @JsonProperty(value = "interests") List<Domain> interests) {
        this.id = id;
        this.email = email;
        this.gender = gender;
        this.age = age;
        this.interests = interests;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Gender getGender() {
        return gender;
    }

    public Integer getAge() {
        return age;
    }

    public List<Domain> getInterests() {
        return interests;
    }
}
