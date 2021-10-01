package com.adam.stan.controllers;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adam.stan.logic.QuestionJSON;
import com.adam.stan.logic.QuizPreparator;
import com.adam.stan.model.Question;
import com.adam.stan.repositories.QuestionRepository;

@RestController
@RequestMapping("/v1")
public class QuestionController {
    private static final Logger log = LoggerFactory.getLogger(QuestionController.class);

    private int amountOfChoices = 4;

    @Autowired
    private QuestionRepository repo;

    @Autowired
    private QuizPreparator quizPreparator;

    @GetMapping("/all/questions")
    List<Question> getAllQuestions() {
        return repo.findAll();
    }

    /**
     * Example: localhost:port/questions/20
     * 
     * @param amount
     * @return
     * @throws Exception
     */
    @GetMapping("/questions/{amount}")
    List<QuestionJSON> getQuestionsFromAllCategories(@PathVariable Integer amount) throws Exception {
        log.info("/questions/{amount} endpoint");
        log.info("Parameter 'amount': " + amount);
        List<Question> questions = repo.findAll();

        return quizPreparator.getQuiz(questions, amount, amountOfChoices);
    }

    /**
     * Example: localhost:port/questions/20/Starozytnosc,Sredniowiecze
     * 
     * @param amount
     * @param categories
     * @return
     */
    @GetMapping("/questions/{amount}/{categories}")
    List<QuestionJSON> getQuestionsFromSpecifiedCategories(@PathVariable Long amount, @PathVariable String[] categories) {
        log.info("Parameter 'amount': " + amount);
        log.info("Parameter 'categories': " + Arrays.toString(categories));
        return quizPreparator.getQuiz(repo.findAllQuestionsFromCategories(categories), amount.intValue(), amountOfChoices);
    }

}