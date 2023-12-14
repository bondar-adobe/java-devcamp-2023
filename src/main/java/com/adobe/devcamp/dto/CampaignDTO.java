package com.adobe.devcamp.dto;

import com.adobe.devcamp.model.Domain;
import com.adobe.devcamp.model.Gender;
import com.adobe.devcamp.model.State;

import java.sql.Timestamp;
import java.util.List;

public class CampaignDTO {
    private final String id;
    private final String name;
    private final Timestamp startTime;
    private final Timestamp endTime;
    private final CampaignDTO.Target target;
    private final String advertiserId;
    private final State state;

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

        private final Gender gender;
        private final List<Domain> interests;
        private final Integer minAge;
        private final Integer maxAge;
    }
}
