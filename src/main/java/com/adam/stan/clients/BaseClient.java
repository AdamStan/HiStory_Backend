package com.adam.stan.clients;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

public abstract class BaseClient {
    @Value("${history.py.apihost}")
    protected String apiHost;
    private String url;

    protected final RestTemplate restTemplate;

    public BaseClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String getApiHost() {
        return apiHost;
    }
    
    protected String baseUrl() {
        if (url == null) {
            url = apiHost + getSecondPartOfBaseUrl();
        }
        return url;
    }
    
    protected abstract String getSecondPartOfBaseUrl();
}
