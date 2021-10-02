package com.adam.stan.clients;

import com.adam.stan.model.Answer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class AnswerClient extends BaseClient {
    private static final String ANSWER_URL = "/v1/answer/";

    public AnswerClient(RestTemplateBuilder restTemplateBuilder) {
        super(restTemplateBuilder);
    }

    public List<Answer> getAnswers() {
//        AnswersList response = restTemplate.getForObject(
//                apiHost + ANSWER_URL,
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
