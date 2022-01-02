package com.adam.stan.clients;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.adam.stan.model.DirectCategory;

@Component
public class CategoryClient extends BaseClient<DirectCategory> {
    private static final String DirectCategory_URL = "/categories";

    public CategoryClient(RestTemplateBuilder restTemplateBuilder) {
        super(restTemplateBuilder);
    }
    
    public List<DirectCategory> getAllCategories() {
        ResponseEntity<DirectCategory[]> response = restTemplate.getForEntity(
                baseUrl(), DirectCategory[].class);
        return Arrays.stream(getArrayFromResponse(response)).collect(Collectors.toList());
    }

    @Override
    protected String getSecondPartOfBaseUrl() {
        return DirectCategory_URL;
    }

}
