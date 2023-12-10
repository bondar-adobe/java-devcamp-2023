package com.adobe.devcamp.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

/**
 * A campaign is a set of strategic activities that promote a business's goal or objective
 */
public final class Campaign {

    private final String name;
    private final Long startTime;
    private final Long endTime;
    private final Target target;
    private final Integer advertiserId;

    @JsonCreator
    public Campaign(@JsonProperty(value = "name") String name,
                    @JsonProperty(value = "startTime") Long startTime,
                    @JsonProperty(value = "endTime") Long endTime,
                    @JsonProperty(value = "target") Target target,
                    @JsonProperty(value = "advertiserId") Integer advertiserId) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.target = target;
        this.advertiserId = advertiserId;
    }

    public String getName() {
        return name;
    }

    public Long getStartTime() {
        return startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public Target getTarget() {
        return target;
    }

    public Integer getAdvertiserId() {
        return advertiserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Campaign campaign = (Campaign) o;
        return Objects.equals(getName(), campaign.getName()) &&
                Objects.equals(getStartTime(), campaign.getStartTime()) &&
                Objects.equals(getEndTime(), campaign.getEndTime()) &&
                Objects.equals(getTarget(), campaign.getTarget()) &&
                Objects.equals(getAdvertiserId(), campaign.getAdvertiserId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getStartTime(), getEndTime(), getTarget(), getAdvertiserId());
    }

    @Override
    public String toString() {
        return "Campaign{" +
                "name='" + name + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", target=" + target +
                ", advertiserId=" + advertiserId +
                '}';
    }

    public static final class Target {
        private final Gender gender;
        private final List<Domain> interests;
        private final short minAge;
        private final short maxAge;

        @JsonCreator
        public Target(@JsonProperty(value = "gender") Gender gender,
                      @JsonProperty(value = "interests") List<Domain> interests,
                      @JsonProperty(value = "minAge") short minAge,
                      @JsonProperty(value = "maxAge") short maxAge) {
            this.gender = gender;
            this.interests = interests;
            this.minAge = minAge;
            this.maxAge = maxAge;
        }

        public Gender getGender() {
            return gender;
        }

        public List<Domain> getInterests() {
            return interests;
        }

        public short getMinAge() {
            return minAge;
        }

        public short getMaxAge() {
            return maxAge;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Target target = (Target) o;
            return getMinAge() == target.getMinAge() &&
                    getMaxAge() == target.getMaxAge() &&
                    getGender() == target.getGender() &&
                    Objects.equals(getInterests(), target.getInterests());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getGender(), getInterests(), getMinAge(), getMaxAge());
        }

        @Override
        public String toString() {
            return "Target{" +
                    "gender=" + gender +
                    ", interests=" + interests +
                    ", minAge=" + minAge +
                    ", maxAge=" + maxAge +
                    '}';
        }
    }
}
