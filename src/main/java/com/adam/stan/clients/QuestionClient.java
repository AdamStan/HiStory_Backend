package com.adam.stan.clients;

import com.adam.stan.model.Answer;
import com.adam.stan.model.Question;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@ConfigurationProperties(value = "history_py", ignoreUnknownFields = false)
public class QuestionClient {

    private static final String QUESTION_URL = "/v1/questions/";

    private String apihost;
    private final RestTemplate restTemplate;

    public QuestionClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public List<Question> getQuestions() {
//        QuestionList response = restTemplate.getForObject(
//                apihost + ANSWER_URL,
//                QuestionList.class);
//        return response.getQuestions();
        // TODO: implement!
        throw new UnsupportedOperationException("Not Implemented yet!");
    }

    public List<Question> getQuestionsByCategories(String[] categories) {
        // TODO: implement!
        throw new UnsupportedOperationException("Not Implemented yet!");
    }
}
