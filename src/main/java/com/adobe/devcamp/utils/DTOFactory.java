package com.adobe.devcamp.utils;

import com.adobe.devcamp.dto.AdvertiserDTO;
import com.adobe.devcamp.dto.CampaignDTO;
import com.adobe.devcamp.dto.UserDTO;
import com.adobe.devcamp.model.Advertiser;
import com.adobe.devcamp.model.Campaign;
import com.adobe.devcamp.model.Domain;
import com.adobe.devcamp.model.Gender;
import com.adobe.devcamp.model.State;
import com.adobe.devcamp.model.User;
import io.vavr.control.Try;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DTOFactory {
    private final ObjectMapper objectMapper;

    public DTOFactory(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public UserDTO userEntityToDTO(User user) {
        return new UserDTO(
            user.getId(),
            user.getEmail(),
            Gender.valueOf(user.getGender()),
            user.getAge(),
            Try.of(
                () -> objectMapper.readValue(user.getInterests(), new TypeReference<List<Domain>>() {}))
                    .get());
    }

    public CampaignDTO campaignEntityToDTO(Campaign campaign) {
        return new CampaignDTO(
                campaign.getId(),
                campaign.getName(),
                campaign.getStartTime(),
                campaign.getEndTime(),
                Try.of(
                    () -> objectMapper.readValue(campaign.getTarget(), CampaignDTO.Target.class))
                        .get(),
                campaign.getAdvertiserId(),
                State.valueOf(campaign.getState()));
    }

    public AdvertiserDTO advertiserEntityToDTO(Advertiser advertiser) {
        return new AdvertiserDTO(
                advertiser.getId(),
                advertiser.getName());
    }
}
