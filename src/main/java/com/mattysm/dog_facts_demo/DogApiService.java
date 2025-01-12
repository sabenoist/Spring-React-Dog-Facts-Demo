package com.mattysm.dog_facts_demo;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * A service class for interacting with the Dog API to retrieve dog-related facts.
 * This class uses {@link RestTemplate} to make HTTP requests to the external API.
 */
@Service
public class DogApiService {
    /**
     * The base URL for the Dog API.
     */
    private static String BASE_URL = "https://dogapi.dog/api/v2";

    /**
     * A {@link RestTemplate} instance for making HTTP requests.
     */
    private final RestTemplate restTemplate;

    /**
     * Constructs a new {@link DogApiService} with the provided {@link RestTemplate} instance.
     *
     * @param restTemplate the {@link RestTemplate} to use for HTTP requests.
     */
    public DogApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Retrieves a list of dog facts from the Dog API.
     *
     * @return a {@link List} of dog facts as strings, or an empty list if an error occurs.
     */
    public List<String> getDogFacts() {
        try {
            // Get the facts from the Dog API
            Map<String, Object> response = restTemplate.getForObject(BASE_URL + "/facts", Map.class);

            List<Map<String, Object>> data = (List<Map<String, Object>>) response.get("data");
            List<String> facts = new ArrayList<>();

            // Extract the facts from the JSON structure and add them to the facts list
            for (Map<String, Object> dogFact : data) {
                Map<String, Object> attributes = (Map<String, Object>) dogFact.get("attributes");
                if (attributes != null && attributes.containsKey("body")) {
                    facts.add((String) attributes.get("body"));
                }
            }

            return facts;
        } catch(Exception e) {
            e.printStackTrace();

            return List.of(); 
        }
    }
}