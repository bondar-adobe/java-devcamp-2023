package com.adobe.devcamp.dto;

import com.adobe.devcamp.model.Domain;
import com.adobe.devcamp.model.Gender;
import com.adobe.devcamp.model.State;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;
import java.util.List;

public class CampaignDTO {
    @JsonProperty private String id;
    @JsonProperty private String name;
    @JsonProperty private Timestamp startTime;
    @JsonProperty private Timestamp endTime;
    @JsonProperty private CampaignDTO.Target target;
    @JsonProperty private String advertiserId;
    @JsonProperty private State state = State.ACTIVE;

    public CampaignDTO(
            String id,
            String name,
            Timestamp startTime,
            Timestamp endTime,
            CampaignDTO.Target target,
            String advertiserId,
            State state) {
        this.id = id;
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.target = target;
        this.advertiserId = advertiserId;
        this.state = state;
    }

    public CampaignDTO() {}

    public static class Target {
        public Target(Gender gender,
                      List<Domain> interests,
                      Integer minAge,
                      Integer maxAge) {
            this.gender = gender;
            this.interests = interests;
            this.minAge = minAge;
            this.maxAge = maxAge;
        }

        public Target() {}

        @JsonProperty private Gender gender;
        @JsonProperty private List<Domain> interests;
        @JsonProperty private Integer minAge;
        @JsonProperty private Integer maxAge;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public Target getTarget() {
        return target;
    }

    public String getAdvertiserId() {
        return advertiserId;
    }

    public State getState() {
        return state;
    }
}
