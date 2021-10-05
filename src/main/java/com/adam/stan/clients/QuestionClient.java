package com.adam.stan.clients;

import com.adam.stan.model.Question;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class QuestionClient extends BaseClient {

    private static final String QUESTION_URL = "/questions/";

    public QuestionClient(RestTemplateBuilder restTemplateBuilder) {
        super(restTemplateBuilder);
    }

    public List<Question> getQuestions() {
        ResponseEntity<Question[]> response = restTemplate.getForEntity(
                apiHost + QUESTION_URL,
                Question[].class);
        return Arrays.stream(response.getBody()).collect(Collectors.toList());
    }

    public List<Question> getQuestionsByCategories(String[] categories) {
        ResponseEntity<Question[]> response = restTemplate.getForEntity(
                apiHost + QUESTION_URL + "?" + getCategoriesSearchString(categories),
                Question[].class);
        return Arrays.stream(response.getBody()).collect(Collectors.toList());
    }

    public String getCategoriesSearchString(String[] categories) {
        StringBuilder builder = new StringBuilder();
        for (String cat : categories) {
            builder.append("category=");
            builder.append(cat);
            builder.append("&");
        }
        return builder.toString();
    }

}
