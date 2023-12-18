package com.adobe.devcamp.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AdvertiserDTO {
    @JsonProperty private String id;
    @JsonProperty private String name;

    public AdvertiserDTO(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public AdvertiserDTO() {}

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
