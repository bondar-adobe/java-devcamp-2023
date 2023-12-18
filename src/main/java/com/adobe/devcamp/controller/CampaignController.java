package com.adobe.devcamp.controller;

import com.adobe.devcamp.dto.CampaignDTO;
import com.adobe.devcamp.dto.UserDTO;
import com.adobe.devcamp.service.CampaignService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.adobe.devcamp.utils.APIRequestsConstants.ID_PATH_PARAM;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
public final class CampaignController {
    private final CampaignService campaignService;

    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    @PostMapping(path = "/campaigns",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public CampaignDTO createCampaign(@RequestBody CampaignDTO campaignDTO) {
        return campaignService.createCampaign(campaignDTO);
    }

    @GetMapping(path = "/campaigns/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public CampaignDTO getCampaignById(@PathVariable("id") String id) {
        // for example: check if the id is correct (not null, not empty, follows a given pattern etc.)
        // before sending it to the next layer
        return campaignService.getCampaignById(id);
    }

    @GetMapping(path = "/campaigns",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CampaignDTO> getCampaigns() {
        return campaignService.getAllCampaigns();
    }

    @GetMapping(path = "/campaigns" + ID_PATH_PARAM + "/users",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO> getAllUsersFromACampaign(@PathVariable("id") String campaignId) {
        return campaignService.getAllUsersFromACampaign(campaignId);
    }

    @DeleteMapping(path = "/campaigns/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteCampaign(@PathVariable("id") String id) {
        campaignService.deleteCampaign(id);
    }
}
