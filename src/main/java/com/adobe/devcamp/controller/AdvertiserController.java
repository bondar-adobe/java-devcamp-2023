package com.adobe.devcamp.controller;

import com.adobe.devcamp.dto.AdvertiserDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import static com.adobe.devcamp.controller.AdvertiserController.ADVERTISERS_CONTROLLER_PATH;

@RestController
@RequestMapping(ADVERTISERS_CONTROLLER_PATH)
public final class AdvertiserController {

    // TODO: implement this functionality

    public static final String ADVERTISERS_CONTROLLER_PATH = "/advertisers";

    public AdvertiserDTO createAdvertiser() {
        // TODO: implement this
        return null;
    }

    public AdvertiserDTO getAdvertiserById() {
        // TODO: implement this
        return null;
    }

    public List<AdvertiserDTO> getAllAdvertisers() {
        // TODO: implement this
        return null;
    }

    public void deleteAdvertiser() {
        // TODO: implement this
    }
}
