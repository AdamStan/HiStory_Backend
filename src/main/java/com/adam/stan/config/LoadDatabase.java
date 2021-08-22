package com.adam.stan.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.adam.stan.model.Answer;
import com.adam.stan.model.AnswerType;
import com.adam.stan.model.Category;
import com.adam.stan.model.Question;
import com.adam.stan.repositories.AnswerTypeRepository;
import com.adam.stan.repositories.CategoryRepository;
import com.adam.stan.repositories.QuestionRepository;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

//    @Bean
//    @Autowired
    public CommandLineRunner initDatabase(CategoryRepository repoCategory, QuestionRepository repoQuestion,
            AnswerTypeRepository repoAnswerType) {
        return args -> {
            Category category = new Category("Dwudziestolecie miedzywojenne");
            log.info("Saving {}", repoCategory.save(category));

            AnswerType type1 = new AnswerType("year");
            log.info("Preloading {}", repoAnswerType.save(type1));

            Question q1 = new Question("Kiedy byl \"Cud nad Wisla\"?", null);
            Answer a1 = new Answer("1920", category, type1);
            q1.setCorrectAnswer(a1);
            log.info("Creating {}", repoQuestion.save(q1));
        };
    }
}
