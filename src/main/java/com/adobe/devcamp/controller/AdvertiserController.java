package com.adobe.devcamp.controller;

import com.adobe.devcamp.exceptions.ResourceNotFoundException;
import com.adobe.devcamp.model.Advertiser;
import com.adobe.devcamp.model.Campaign;
import com.adobe.devcamp.model.Publisher;
import com.adobe.devcamp.model.User;
import com.adobe.devcamp.service.AdvertisingService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AdvertiserController {

    private final AdvertisingService<Campaign> campaignService;
    private final AdvertisingService<Advertiser> advertiserService;
    private final AdvertisingService<Publisher> publisherService;
    private final AdvertisingService<User> userAdvertisingService;

    public AdvertiserController(AdvertisingService<Campaign> campaignService, AdvertisingService<Advertiser> advertiserService, AdvertisingService<Publisher> publisherService, AdvertisingService<User> userAdvertisingService) {
        this.campaignService = campaignService;
        this.advertiserService = advertiserService;
        this.publisherService = publisherService;
        this.userAdvertisingService = userAdvertisingService;
    }

    @GetMapping(path = "/campaigns/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Campaign getCampaignById(@PathVariable("id") Integer id) throws ResourceNotFoundException {
        Campaign campaign = campaignService.selectById(Campaign.class, id);
        if (campaign == null) {
            throw new ResourceNotFoundException(id.toString());
        }

        return campaign;
    }

    //TODO IMPLEMENT THIS METHOD
    @GetMapping(path = "/publishers", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Publisher> getPublishers(@RequestParam(name = "advertiserId") Integer advertiserId) {

        //DELETE THIS LINE WHEN YOU START IMPLEMENTING THIS METHOD
        return null;
    }

    //TODO IMPLEMENT THIS METHOD
    @GetMapping(path = "/advertisers/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getTargetedUsers(@RequestParam(name = "advertiserId") Integer advertiserId,
                                       @RequestParam(name = "campaignId") Integer campaignId) {

        //DELETE THIS LINE WHEN YOU START IMPLEMENTING THIS METHOD
        return null;
    }

    //TODO IMPLEMENT THIS METHOD
    private List<User> getTargetedUsersFor(Publisher publisher, Campaign campaign) {

        //DELETE THIS LINE WHEN YOU START IMPLEMENTING THIS METHOD
        return null;
    }

}
