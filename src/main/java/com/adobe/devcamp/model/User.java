package com.adobe.devcamp.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public final class User {

    private final String firstName;
    private final String lastName;
    private final String email;
    private final Profile profile;

    @JsonCreator
    public User(
            @JsonProperty(value="firstName") String firstName,
            @JsonProperty(value="lastName") String lastName,
            @JsonProperty(value="email") String email,
            @JsonProperty(value="profile") Profile profile) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.profile = profile;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Profile getProfile() {
        return profile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getFirstName(), user.getFirstName()) &&
                Objects.equals(getLastName(), user.getLastName()) &&
                Objects.equals(getEmail(), user.getEmail()) &&
                Objects.equals(getProfile(), user.getProfile());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getEmail(), getProfile());
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", profile=" + profile +
                '}';
    }

    public static class Profile {
        private final Gender gender;
        @JsonSerialize(using = LocalDateSerializer.class)
        @JsonDeserialize(using = LocalDateDeserializer.class)
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
        private final LocalDate dateOfBirth;
        private final List<Domain> interests;

        @JsonCreator
        public Profile(
                @JsonProperty(value="gender")Gender gender,
                @JsonProperty(value="dateOfBirth")LocalDate dateOfBirth,
                @JsonProperty(value="interests")List<Domain> interests) {
            this.gender = gender;
            this.dateOfBirth = dateOfBirth;
            this.interests = interests;
        }

        public Gender getGender() {
            return gender;
        }

        public LocalDate getDateOfBirth() {
            return dateOfBirth;
        }

        public List<Domain> getInterests() {
            return interests;
        }

        @Override
        public String toString() {
            return "Profile{" +
                    "gender=" + gender +
                    ", dateOfBirth=" + dateOfBirth +
                    ", interests=" + interests +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Profile profile = (Profile) o;
            return getGender() == profile.getGender() &&
                    Objects.equals(getDateOfBirth(), profile.getDateOfBirth()) &&
                    Objects.equals(getInterests(), profile.getInterests());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getGender(), getDateOfBirth(), getInterests());
        }
    }
}

