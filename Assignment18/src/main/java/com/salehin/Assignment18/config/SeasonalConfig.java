package com.salehin.Assignment18.config;

import com.salehin.Assignment18.service.GreetingService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class SeasonalConfig {
    @Bean
    @Profile("summer")
    public GreetingService summerGreeting(
            @Value("${app.message}") String message) {
        return () -> message;
    }

    @Bean
    @Profile("winter")
    public GreetingService winterGreeting(
            @Value("${app.message}") String message) {
        return () -> message;
    }
}
