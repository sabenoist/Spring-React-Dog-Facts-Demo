package com.mattysm.dog_facts_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * The main entry point for the Dog Facts Demo.
 * This class configures and runs the Spring Boot application.
 * NOTE: CORS is disabled!
 */
@SpringBootApplication
public class DogFactsDemoApplication {

    /**
     * Creates and provides a {@link RestTemplate} bean.
     * This bean is used for making HTTP requests within the application.
     *
     * @return a new instance of {@link RestTemplate}.
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * The main method that launches the demo.
     *
     * @param args command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        SpringApplication.run(DogFactsDemoApplication.class, args);
    }
}