package com.adam.stan.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.adam.stan.clients.AnswerClient;
import com.adam.stan.clients.QuestionClient;
import com.adam.stan.config.Database;
import com.adam.stan.logic.QuizPreparation;

@SpringBootTest
class QuestionControllerMockedTests {
    private MockMvc mocked;
    private final Database database = new Database();

    @InjectMocks
    private QuestionController questionController;
    @Mock
    private QuestionClient questionClient;
    @MockBean
    private AnswerClient answerClient;
    @SpyBean
    private QuizPreparation quizPreparation;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mocked = MockMvcBuilders.standaloneSetup(questionController).build();
        when(questionClient.getQuestions()).thenReturn(database.getQuestions());
        when(questionClient.getQuestionsByCategories(any())).thenReturn(database.getQuestions());
        when(answerClient.getAnswersByType(any())).thenReturn(database.getAnswers());
        when(answerClient.getAnswersByTypeAndCategory(any(), any())).thenReturn(database.getAnswers());
    }

    @Test
    void questionControllerShouldReturn() throws Exception {
        mocked.perform(get("/v1/all/questions")).andDo(print())
           .andExpect(status().isOk());
    }

    @Test
    void questionControllerShouldReturn2() throws Exception {
        mocked.perform(get("/v1/questions/10")).andDo(print())
              .andExpect(status().isOk());
    }

    @Test
    void questionControllerShouldReturn3() throws Exception {
        mocked.perform(get("/v1/questions/20/cat2")).andDo(print())
              .andExpect(status().isOk());
    }

}
