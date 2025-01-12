package com.mattysm.dog_facts_demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * A REST controller for exposing endpoints related to dog facts.
 * This controller handles HTTP requests and delegates the logic to the {@link DogApiService}.
 */
@RestController
@RequestMapping("/api")
public class DogApiController {
    /**
     * The service layer responsible for retrieving dog facts.
     */
    private final DogApiService dogApiService;

    /**
     * Constructs a new {@link DogApiController} with the provided {@link DogApiService} instance.
     *
     * @param dogApiService the service used to fetch dog facts.
     */
    public DogApiController(DogApiService dogApiService) {
        this.dogApiService = dogApiService;
    }

    /**
     * Endpoint to retrieve a list of dog facts.
     * Handles GET requests to the "/dog-facts" endpoint.
     *
     * @return a {@link List} of dog facts as strings.
     */
    @GetMapping("/dog-facts")
    public List<String> getDogFacts() {
        return dogApiService.getDogFacts();
    }
}
