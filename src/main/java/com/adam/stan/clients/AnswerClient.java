package com.adam.stan.clients;

import com.adam.stan.model.Answer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AnswerClient extends BaseClient {
    private static final String ANSWER_URL = "/answers/";

    public AnswerClient(RestTemplateBuilder restTemplateBuilder) {
        super(restTemplateBuilder);
    }

    public List<Answer> getAnswers() {
        ResponseEntity<Answer[]> response = restTemplate.getForEntity(
                apiHost + ANSWER_URL ,
                Answer[].class);
        return Arrays.stream(response.getBody()).collect(Collectors.toList());
    }

    public List<Answer> getAnswersByType(String type) {
        ResponseEntity<Answer[]> response = restTemplate.getForEntity(
                apiHost + ANSWER_URL + "?type={type}",
                Answer[].class,
                type);
        return Arrays.stream(response.getBody()).collect(Collectors.toList());
    }

    public List<Answer> getAnswersByTypeAndCategory(String type, String category) {
        ResponseEntity<Answer[]> response = restTemplate.getForEntity(
                apiHost + ANSWER_URL + "?type={type}&category={category}",
                Answer[].class,
                type,
                category);
        return Arrays.stream(response.getBody()).collect(Collectors.toList());
    }
}
