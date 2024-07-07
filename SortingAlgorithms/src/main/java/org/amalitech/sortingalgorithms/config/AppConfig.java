package org.amalitech.sortingalgorithms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.amalitech.sortingalgorithms.services.SortingService;
import org.amalitech.sortingalgorithms.services.SortingImplementation;

/**
 * This class defines the configuration for the Spring application.
 * It is marked with @Configuration to indicate that it is a source of bean definitions.
 */
@Configuration
public class AppConfig {

    /**
     * This method defines a bean for SortingService.
     * The @Bean annotation tells Spring that this method will return an object that should be registered as a bean in the Spring application context.
     * The method returns an instance of SortingImplementation, which is a concrete implementation of the SortingService interface.
     *
     * @return a SortingService implementation instance
     */
    @Bean
    public SortingService sortingService() {
        return new SortingImplementation();
    }
}