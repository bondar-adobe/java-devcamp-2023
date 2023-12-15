package com.adobe.devcamp.controller;

import com.adobe.devcamp.dto.AdvertiserDTO;
import com.adobe.devcamp.service.AdvertiserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.adobe.devcamp.controller.AdvertiserController.ADVERTISERS_CONTROLLER_PATH;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(ADVERTISERS_CONTROLLER_PATH)
public final class AdvertiserController {
    public static final String ADVERTISERS_CONTROLLER_PATH = "/advertisers";
    private final AdvertiserService advertiserService;

    public AdvertiserController(AdvertiserService advertiserService) {
        this.advertiserService = advertiserService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(CREATED)
    public AdvertiserDTO createAdvertiser(@RequestBody AdvertiserDTO advertiserDTO) {
        return advertiserService.createAdvertiser(advertiserDTO);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public AdvertiserDTO getAdvertiserById(@PathVariable("id") String advertiserId) {
        return advertiserService.getAdvertiserById(advertiserId);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public List<AdvertiserDTO> getAllAdvertisers() {
        return advertiserService.getAllAdvertisers();
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteAdvertiser(@PathVariable("id") String advertiserId) {
        advertiserService.deleteAdvertiser(advertiserId);
    }
}
