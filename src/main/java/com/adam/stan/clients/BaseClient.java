package com.adam.stan.clients;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.adam.stan.clients.exceptions.EmptyBodyException;

public abstract class BaseClient<T> {
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
    
    protected T[] getArrayFromResponse(ResponseEntity<T[]> response) {
        var body = response.getBody();
        if (body == null) {
            throw new EmptyBodyException("Body is empty for QuestionClient!");
        }
        return body;
    }
}
