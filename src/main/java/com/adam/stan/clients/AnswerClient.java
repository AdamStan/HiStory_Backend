package com.adam.stan.clients;

import com.adam.stan.clients.exceptions.EmptyBodyException;
import com.adam.stan.model.Answer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AnswerClient extends BaseClient<Answer> {
    private static final String ANSWER_URL = "/answers/";

    public AnswerClient(RestTemplateBuilder restTemplateBuilder) {
        super(restTemplateBuilder);
    }

    /**
     * Gets all answers by given type from remote host
     * @return list of answers
     * @throws EmptyBodyException when remote host returns response without body
     */
    public List<Answer> getAnswersByType(String type) {
        ResponseEntity<Answer[]> response = restTemplate.getForEntity(baseUrl() + "?type={type}", Answer[].class, type);
        return Arrays.stream(getArrayFromResponse(response)).collect(Collectors.toList());
    }

    /**
     * Gets all answers by given type and category from remote host
     * @return list of answers
     * @throws EmptyBodyException when remote host returns response without body
     */
    public List<Answer> getAnswersByTypeAndCategory(String type, String category) {
        ResponseEntity<Answer[]> response = restTemplate.getForEntity(baseUrl() + "?type={type}&period={category}",
                Answer[].class, type, category);
        return Arrays.stream(getArrayFromResponse(response)).collect(Collectors.toList());
    }

    @Override
    protected String getSecondPartOfBaseUrl() {
        return ANSWER_URL;
    }

}
