package com.adobe.devcamp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import java.sql.Timestamp;

@Entity
public class Advertiser {
    @Id private String id;
    private String name;
    private Timestamp createdDate;

    @PrePersist
    public void prePersist() {
        this.createdDate = new Timestamp(System.currentTimeMillis());
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
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

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }
}
