package com.adobe.devcamp.repository;

import com.adobe.devcamp.dto.AdvertiserDTO;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class AdvertiserRepository {
    private List<AdvertiserDTO> storedAdvertisers;

    public AdvertiserRepository() {
        this.storedAdvertisers = new LinkedList<>();
    }
}
