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
    
    /*
         TODO
         1. ADD RELEVANT FIELDS
         2. ADD CONSTRUCTOR
         3. ADD GETTERS
         4. ADD EQUALS AND HASHCODE
         5. ADD TOSTRING
         
     */

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

