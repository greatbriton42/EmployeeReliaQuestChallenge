package com.reliaquest.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class AppConfig {
    private static final String BASE_URL = "http://localhost:8112/api/v1";

    @Bean
    public RestClient restClient() {
        return RestClient.builder().baseUrl(BASE_URL).build();
    }
}
