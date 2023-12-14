package com.adobe.devcamp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Advertiser {
    @Id private String id;
    private String name;
}
