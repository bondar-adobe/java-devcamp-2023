package com.adobe.devcamp.service;

import com.adobe.devcamp.dto.AdvertiserDTO;
import com.adobe.devcamp.model.Advertiser;
import com.adobe.devcamp.repository.AdvertiserRepository;
import com.adobe.devcamp.utils.DTOFactory;
import com.adobe.devcamp.utils.EntityFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertiserService {
    // This service should provide all the necessary methods for managing advertisers.
    // This includes:
    //    1. Creating a new advertiser
    //    2. Fetching a campaigns by id from the database
    //    3. Fetching all campaigns
    //    4. Deleting a campaigns
    //    5. Retrieving all users targeted by this campaign
    private final AdvertiserRepository advertiserRepository;
    private final EntityFactory entityFactory;
    private final DTOFactory dtoFactory;

    public AdvertiserService(AdvertiserRepository advertiserRepository, EntityFactory entityFactory, DTOFactory dtoFactory) {
        this.advertiserRepository = advertiserRepository;
        this.entityFactory = entityFactory;
        this.dtoFactory = dtoFactory;
    }

    public AdvertiserDTO getAdvertiserById(String advertiserId) {
        return advertiserRepository.findById(advertiserId)
                .map(dtoFactory::advertiserEntityToDTO)
                .orElse(null);
    }

    public List<AdvertiserDTO> getAllAdvertisers() {
        return advertiserRepository.findAll()
                .stream().map(dtoFactory::advertiserEntityToDTO)
                .collect(java.util.stream.Collectors.toList());
    }

    public AdvertiserDTO createAdvertiser(AdvertiserDTO advertiserDTO) {
        final Advertiser advertiser = entityFactory.advertiserDTOToEntity(advertiserDTO);
        final Advertiser savedAdvertiser = advertiserRepository.save(advertiser);
        return dtoFactory.advertiserEntityToDTO(savedAdvertiser);
    }

    public void deleteAdvertiser(String advertiserId) {
        advertiserRepository.deleteById(advertiserId);
    }
}
