package com.adobe.devcamp.repository;

import com.adobe.devcamp.dto.CampaignDTO;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class CampaignRepository {
    private List<CampaignDTO> storedCampaigns;

    public CampaignRepository() {
        this.storedCampaigns = new LinkedList<>();
    }
}
