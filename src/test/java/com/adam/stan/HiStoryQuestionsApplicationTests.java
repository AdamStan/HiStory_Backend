package com.adam.stan;

import static org.assertj.core.api.Assertions.assertThat;

import com.adam.stan.clients.AnswerClient;
import com.adam.stan.clients.QuestionClient;
import com.adam.stan.logic.QuestionPreparation;
import com.adam.stan.logic.QuizPreparation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.adam.stan.controllers.QuestionController;

@SpringBootTest
class HiStoryQuestionsApplicationTests {
    @Autowired
    private QuestionController questionController;

    @Autowired
    private QuestionClient questionClient;

    @Autowired
    private AnswerClient answerClient;

    @Autowired
    private QuestionPreparation questionPreparation;

    @Autowired
    private QuizPreparation quizPreparation;

    @Test
    void contextLoads() {
        assertThat(questionController).isNotNull();
        assertThat(questionClient).isNotNull();
        assertThat(questionClient.getApiHost()).isNotNull();
        assertThat(answerClient).isNotNull();
        assertThat(questionPreparation).isNotNull();
        assertThat(quizPreparation).isNotNull();
    }

}
