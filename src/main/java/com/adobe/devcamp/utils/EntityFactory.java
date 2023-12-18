package com.adobe.devcamp.utils;

import com.adobe.devcamp.dto.AdvertiserDTO;
import com.adobe.devcamp.dto.CampaignDTO;
import com.adobe.devcamp.dto.UserDTO;
import com.adobe.devcamp.model.Advertiser;
import com.adobe.devcamp.model.Campaign;
import com.adobe.devcamp.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.StringWriter;
import java.util.UUID;

@Component
public class EntityFactory {
    private final ObjectMapper objectMapper;

    public EntityFactory(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public User userDTOToEntity(UserDTO userDTO) {
        User modeUser = new User();
        if (userDTO.getId() != null && !userDTO.getId().isEmpty()) {
            modeUser.setId(userDTO.getId());
        } else {
            modeUser.setId(UUID.randomUUID().toString());
        }
        modeUser.setEmail(userDTO.getEmail());
        modeUser.setGender(userDTO.getGender().toString());
        modeUser.setAge(userDTO.getAge());
        modeUser.setInterests(writeValue(userDTO.getInterests()));
        return modeUser;
    }

    public Campaign campaignDTOToEntity(CampaignDTO campaignDTO) {
        Campaign campaign = new Campaign();
        if (campaignDTO.getId() != null && !campaignDTO.getId().isEmpty()) {
            campaign.setId(campaignDTO.getId());
        } else {
            campaign.setId(UUID.randomUUID().toString());
        }
        campaign.setName(campaignDTO.getName());
        campaign.setStartTime(campaignDTO.getStartTime());
        campaign.setEndTime(campaignDTO.getEndTime());
        campaign.setAdvertiserId(campaignDTO.getAdvertiserId());
        campaign.setState(campaignDTO.getState().toString());
        campaign.setTarget(writeValue(campaignDTO.getTarget()));
        return campaign;
    }

    public Advertiser advertiserDTOToEntity(AdvertiserDTO advertiserDTO) {
        Advertiser advertiser = new Advertiser();
        if (advertiserDTO.getId() != null && !advertiserDTO.getId().isEmpty()) {
            advertiser.setId(advertiserDTO.getId());
        } else {
            advertiser.setId(UUID.randomUUID().toString());
        }
        advertiser.setName(advertiserDTO.getName());
        return advertiser;
    }

    private String writeValue(Object source) {
        if (source == null) {
            return "";
        }
        try {
            StringWriter serializationWriter = new StringWriter();
            objectMapper.writeValue(serializationWriter, source);
            serializationWriter.flush();

            return serializationWriter.toString();
        } catch (Exception e) {
           // throw a custom exception like "Failing to serialize to JSON output, exception"
            return null;
        }
    }

}
