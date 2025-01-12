package com.mattysm.dog_facts_demo;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Unit tests for the {@link DogApiService} class.
 */
class DogApiServiceTest {

    /**
     * Tests the {@link DogApiService#getDogFacts()} method for correct behavior when the Dog API returns valid data.
     */
    @Test
    void testGetDogFacts_Success() {
        DogApiService dogApiService = new DogApiService(new RestTemplate());

        List<String> dogFacts = dogApiService.getDogFacts();

        assertNotNull(dogFacts, "The list of dog facts should not be null.");
        assertFalse(dogFacts.isEmpty(), "The list of dog facts should not be empty on success.");
    }

    /**
     * Tests the {@link DogApiService#getDogFacts()} method for correct behavior when an exception occurs using a mock API.
     */
    @Test
    void testGetDogFacts_Exception() {
        RestTemplate restTemplateMock = mock(RestTemplate.class);
        DogApiService dogApiService = new DogApiService(restTemplateMock);

        // Mock API throwing an exception
        when(restTemplateMock.getForObject(Mockito.anyString(), eq(Map.class))).thenThrow(new RuntimeException("API error"));

        List<String> dogFacts = dogApiService.getDogFacts();

        assertNotNull(dogFacts, "The list of dog facts should not be null.");
        assertTrue(dogFacts.isEmpty(), "The list of dog facts should be empty when an exception occurs.");

        // Verify that the API was called once
        verify(restTemplateMock, times(1)).getForObject(Mockito.anyString(), eq(Map.class));
    }
}
