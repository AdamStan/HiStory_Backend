package com.adam.stan.clients;

import com.adam.stan.clients.exceptions.EmptyBodyException;
import com.adam.stan.model.Question;
import com.adam.stan.util.CategorySearchStringBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class QuestionClient extends BaseClient<Question> {

    private static final String QUESTION_URL = "/questions/";
    private final CategorySearchStringBuilder queryBuilder;

    public QuestionClient(RestTemplateBuilder restTemplateBuilder,
                          CategorySearchStringBuilder queryBuilder) {
        super(restTemplateBuilder);
        this.queryBuilder = queryBuilder;
    }

    /**
     * Gets all questions from remote host
     *
     * @return list of questions
     * @throws EmptyBodyException when remote host returns response without body
     */
    public List<Question> getQuestions() {
        ResponseEntity<Question[]> response = restTemplate.getForEntity(baseUrl(), Question[].class);
        return Arrays.stream(getArrayFromResponse(response)).collect(Collectors.toList());
    }

    /**
     * Gets all questions by given categories from remote host
     *
     * @return list of questions
     * @throws EmptyBodyException when remote host returns response without body
     */
    public List<Question> getQuestionsByCategories(String[] categories) {
        ResponseEntity<Question[]> response = restTemplate.getForEntity(
                baseUrl() + "?" + queryBuilder.getCategorySearchString(categories), 
                Question[].class);
        return Arrays.stream(getArrayFromResponse(response)).collect(Collectors.toList());
    }

    @Override
    protected String getSecondPartOfBaseUrl() {
        return QUESTION_URL;
    }

}
