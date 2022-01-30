package com.example.skenariolabs.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfiguration {
    @Value("${geoapify.baseUrl}")
    private String baseUrl;

    @Bean
    public WebClient localApiClient() {
        return WebClient.create(baseUrl);
    }


}
