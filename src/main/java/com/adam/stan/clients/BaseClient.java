package com.adam.stan.clients;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

public class BaseClient {
    @Value("${history.py.apihost}")
    protected String apiHost;

    protected final RestTemplate restTemplate;

    public BaseClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String getApiHost() {
        return apiHost;
    }
}
