package com.adam.stan.clients;

import com.adam.stan.model.Question;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class QuestionClient extends BaseClient {

    private static final String QUESTION_URL = "/v1/questions/";

    public QuestionClient(RestTemplateBuilder restTemplateBuilder) {
        super(restTemplateBuilder);
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
