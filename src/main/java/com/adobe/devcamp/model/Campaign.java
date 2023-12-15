package com.adobe.devcamp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "advertising_campaign")
public class Campaign {

    @Id private String id;
    private String name;
    private Timestamp startTime;
    private Timestamp endTime;
    private String target;
    private String advertiserId;
    private String state;
    private Timestamp createdDate;

    @PrePersist
    public void prePersist() {
        final Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        this.createdDate = currentTimestamp;
        currentTimestamp.setTime(currentTimestamp.getTime() + 1000 * 60 * 60 * 24);
        this.startTime = currentTimestamp;
        currentTimestamp.setTime(currentTimestamp.getTime() + 1000 * 60 * 60 * 24 * 7);
        this.endTime = currentTimestamp;
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

    public String getTarget() {
        return target;
    }

    public String getAdvertiserId() {
        return advertiserId;
    }

    public String getState() {
        return state;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public void setAdvertiserId(String advertiserId) {
        this.advertiserId = advertiserId;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }
}
