package com.adam.stan.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

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

    @Autowired
    private CategoryRepository repoCategory;
    @Autowired
    private QuestionRepository repoQuestion;
    @Autowired
    private AnswerTypeRepository repoAnswerType;

    @Bean
    @Profile("test")
    public CommandLineRunner initDatabase() {
        return args -> {
            Category category = new Category("cat1");
            log.info("Saving {}", repoCategory.save(category));
            Category cat2 = new Category("cat2");
            log.info("Saving {}", repoCategory.save(cat2));

            AnswerType type1 = new AnswerType("type1");
            log.info("Preloading {}", repoAnswerType.save(type1));
            createQuestions(0, 100, category, type1);
            createQuestions(100, 100, cat2, type1);
        };
    }

    private void createQuestions(int startIndex, int amount, Category category, AnswerType type) {
        for (int i = startIndex; i < startIndex + amount; i++) {
            Question q = createBaseQuestionAnswer(category, type, i);
            log.info("Creating {}", repoQuestion.save(q));
        }
    }

    private Question createBaseQuestionAnswer(Category category, AnswerType type, int i) {
        Question q1 = new Question("Question" + i + "?", null);
        Answer a1 = new Answer("Answer" + i, category, type);
        q1.setCorrectAnswer(a1);
        return q1;
    }

    public CommandLineRunner initDatabaseBase(CategoryRepository repoCategory, QuestionRepository repoQuestion,
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
