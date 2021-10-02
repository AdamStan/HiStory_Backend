package com.adam.stan.clients;

import com.adam.stan.model.Answer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@ConfigurationProperties(value = "history_py", ignoreUnknownFields = false)
public class AnswerClient {
    private static final String ANSWER_URL = "/v1/answer/";

    private String apihost;
    private final RestTemplate restTemplate;

    public AnswerClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public List<Answer> getAnswers() {
//        AnswersList response = restTemplate.getForObject(
//                apihost + ANSWER_URL,
//                AnswersList.class);
//        return response.getAnswers();
        // TODO: implement!
        throw new UnsupportedOperationException("Not Implemented yet!");
    }

    public List<Answer> getAnswersByType(String type) {
        // TODO: implement!
        throw new UnsupportedOperationException("Not Implemented yet!");
    }

    public List<Answer> getAnswersByTypeAndCategory(String type, String category) {
        // TODO: implement!
        throw new UnsupportedOperationException("Not Implemented yet!");
    }
}
