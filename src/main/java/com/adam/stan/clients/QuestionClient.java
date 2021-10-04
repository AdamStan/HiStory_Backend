package com.adam.stan.clients;

import com.adam.stan.model.Question;
import com.adam.stan.model.QuestionsList;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class QuestionClient extends BaseClient {

    private static final String QUESTION_URL = "/api/questions/";

    public QuestionClient(RestTemplateBuilder restTemplateBuilder) {
        super(restTemplateBuilder);
    }

    public List<Question> getQuestions() {
        ResponseEntity<Question[]> response = restTemplate.getForEntity(
                apiHost + QUESTION_URL,
                Question[].class);
        return Arrays.stream(response.getBody()).toList();
    }

    public List<Question> getQuestionsByCategories(String[] categories) {
        // TODO: implement!
        throw new UnsupportedOperationException("Not Implemented yet!");
    }

}
