package com.adobe.devcamp.service;

import com.adobe.devcamp.dto.CampaignDTO;
import com.adobe.devcamp.dto.UserDTO;
import com.adobe.devcamp.model.Campaign;
import com.adobe.devcamp.repository.CampaignRepository;
import com.adobe.devcamp.utils.DTOFactory;
import com.adobe.devcamp.utils.EntityFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CampaignService {
    // This service should provide all the necessary methods for managing campaigns.
    // This includes:
    //    1. Creating a new campaigns
    //    2. Fetching a campaign by id from the database
    //    3. Fetching all campaigns
    //    4. Deleting a campaign
    //    5. Retrieving all users targeted by this campaign
    private final CampaignRepository campaignRepository;
    private final EntityFactory entityFactory;
    private final DTOFactory dtoFactory;

    public CampaignService(CampaignRepository campaignRepository,
                           EntityFactory entityFactory,
                           DTOFactory dtoFactory) {
        this.campaignRepository = campaignRepository;
        this.entityFactory = entityFactory;
        this.dtoFactory = dtoFactory;
    }
    
    public CampaignDTO getCampaignById(String campaignId) {
        return campaignRepository.findById(campaignId)
                .map(dtoFactory::campaignEntityToDTO)
                .orElse(null);
    }

    public List<CampaignDTO> getAllCampaigns() {
        return campaignRepository.findAll()
                .stream().map(dtoFactory::campaignEntityToDTO)
                .collect(java.util.stream.Collectors.toList());
    }

    public CampaignDTO createCampaign(CampaignDTO campaignDTO) {
        final Campaign campaign = entityFactory.campaignDTOToEntity(campaignDTO);
        final Campaign savedCampaign = campaignRepository.save(campaign);
        return dtoFactory.campaignEntityToDTO(savedCampaign);
    }

    public List<UserDTO> getAllUsersFromACampaign(String campaignId) {
        // TODO(streams): how about using streams here?
        return null;
    }

    public void deleteCampaign(String campaignId) {
        campaignRepository.deleteById(campaignId);
    }
}
