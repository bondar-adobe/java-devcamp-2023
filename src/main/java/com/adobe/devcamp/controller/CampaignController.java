package com.adobe.devcamp.controller;

import com.adobe.devcamp.dto.CampaignDTO;
import com.adobe.devcamp.dto.UserDTO;
import com.adobe.devcamp.service.CampaignService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CampaignController {
    private static final String ID_PATH_PARAM = "/{id}";

    private final CampaignService campaignService;

    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    @PostMapping(path = "/campaigns",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public CampaignDTO createCampaign(@RequestBody CampaignDTO campaignDTO) {
        // TODO: implement this
        return campaignDTO;
    }

    @GetMapping(path = "/campaigns",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public CampaignDTO getCampaignById(@PathVariable("id") String id) {
        // TODO: implement this
        return null;
    }

    @GetMapping(path = "/campaigns" + ID_PATH_PARAM + "/users",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO> getAllUsersFromACampaign(@PathVariable("id") String id) {
        // TODO: how about using streams here?
        return null;
    }

}
