package com.adam.stan;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.adam.stan.controllers.CategoryController;
import com.adam.stan.controllers.QuestionController;
import com.adam.stan.repositories.AnswerTypeRepository;
import com.adam.stan.repositories.CategoryRepository;
import com.adam.stan.repositories.QuestionRepository;

@SpringBootTest
class HiStoryQuestionsApplicationTests {
    @Autowired
    private QuestionController questionController;

    @Autowired
    private CategoryController categoryController;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private AnswerTypeRepository answerTypeRepository;

    @Test
    void contextLoads() {
        assertThat(questionController).isNotNull();
        assertThat(categoryController).isNotNull();
        assertThat(questionRepository).isNotNull();
        assertThat(categoryRepository).isNotNull();
        assertThat(answerTypeRepository).isNotNull();
    }

}
