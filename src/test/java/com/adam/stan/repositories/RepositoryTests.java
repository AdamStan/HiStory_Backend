package com.adam.stan.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.adam.stan.HiStoryQuestionsApplication;
import com.adam.stan.model.Answer;
import com.adam.stan.model.AnswerType;
import com.adam.stan.model.Category;
import com.adam.stan.model.Question;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HiStoryQuestionsApplication.class)
public class RepositoryTests {

    @Autowired
    private QuestionRepository repo;
    
    @Autowired
    private CategoryRepository catRepo;
    
    @Autowired
    private AnswerTypeRepository answerTypeRepo;

    @Test
    public void testFindAllQuestionsFromCategories() {
        Category category = new Category("Dwudziestolecie miedzywojenne");
        Category category2 = new Category("I wojna swiatowa");
        AnswerType type1 = new AnswerType("year");
        catRepo.save(category);
        catRepo.save(category2);
        answerTypeRepo.save(type1);
        Question q1 = new Question("Kiedy byl \"Cud nad Wisla\"?", null);
        Question q2 = new Question("W ktorym roku wybuchla I wojna swiatowa", null);
        Answer a1 = new Answer("1920", category, type1);
        Answer a2 = new Answer("1914", category2, type1);
        q1.setCorrectAnswer(a1);
        q2.setCorrectAnswer(a2);
        repo.save(q1);
        repo.save(q2);

//        List<Question> questions = repo.findAllQuestionsFromCategories(category);
//        assertThat(questions).hasSize(1);
    }
}
