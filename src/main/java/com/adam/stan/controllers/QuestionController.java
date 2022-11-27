package com.adam.stan.controllers;

import java.util.Arrays;
import java.util.List;

import com.adam.stan.clients.QuestionClient;
import com.adam.stan.dto.QuestionDto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.adam.stan.logic.QuizPreparation;
import com.adam.stan.model.Question;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/v1")
public class QuestionController {
    private static final Logger log = LoggerFactory.getLogger(QuestionController.class);

    private final int amountOfChoices = 4;

    @Autowired
    private QuestionClient client;

    @Autowired
    private QuizPreparation preparation;

    @GetMapping("/all/questions")
    List<Question> getAllQuestions() {
        return client.getQuestions();
    }

    /**
     * Example: localhost:port/questions/20
     * 
     * @param amount
     * @return
     */
    @GetMapping("/questions/{amount}")
    List<QuestionDto> getQuestionsFromAllCategories(@PathVariable Integer amount) {
        log.info("/questions/{amount} endpoint");
        log.info("Parameter 'amount': " + amount);
        List<Question> questions = client.getQuestions();

        return preparation.getQuiz(questions, amount, amountOfChoices);
    }

    /**
     * Example: localhost:port/questions/20/Starozytnosc,Sredniowiecze
     * 
     * @param amount
     * @param categories
     * @return
     */
    @GetMapping("/questions/{amount}/{categories}")
    List<QuestionDto> getQuestionsFromSpecifiedCategories(@PathVariable Long amount, @PathVariable String[] categories) {
        log.info("Parameter 'amount': " + amount);
        log.info("Parameter 'categories': " + Arrays.toString(categories));
        return preparation.getQuiz(client.getQuestionsByCategories(categories), amount.intValue(), amountOfChoices);
    }

}
