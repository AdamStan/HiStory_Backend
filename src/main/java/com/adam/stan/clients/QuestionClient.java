package com.adam.stan.clients;

import com.adam.stan.clients.exceptions.EmptyBodyException;
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
    private final String url = apiHost + QUESTION_URL;

    public QuestionClient(RestTemplateBuilder restTemplateBuilder) {
        super(restTemplateBuilder);
    }

    public List<Question> getQuestions() {
        ResponseEntity<Question[]> response = restTemplate.getForEntity(url, Question[].class);
        return Arrays.stream(getAnswersFromResponse(response)).collect(Collectors.toList());
    }

    public List<Question> getQuestionsByCategories(String[] categories) {
        ResponseEntity<Question[]> response = restTemplate.getForEntity(
                url + "?" + getCategoriesSearchString(categories),
                Question[].class);
        return Arrays.stream(getAnswersFromResponse(response)).collect(Collectors.toList());
    }

    private String getCategoriesSearchString(String[] categories) {
        StringBuilder builder = new StringBuilder();
        for (String cat : categories) {
            builder.append("category=");
            builder.append(cat);
            builder.append("&");
        }
        return builder.toString();
    }

    private Question[] getAnswersFromResponse(ResponseEntity<Question[]> response) {
        var body = response.getBody();
        if (body == null) {
            throw new EmptyBodyException("Body is empty for QuestionClient!");
        }
        return body;
    }

}
