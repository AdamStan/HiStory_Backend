package com.adam.stan.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.adam.stan.logic.QuestionJSON;
import com.adam.stan.logic.QuestionPreparator;
import com.adam.stan.model.Question;
import com.adam.stan.repositories.QuestionRepository;
import com.adam.stan.util.RandomItemsFromList;
import com.adam.stan.util.exceptions.NotEnoughItemsOnListException;

@RestController
public class QuestionController {
    private static final Logger log = LoggerFactory.getLogger(QuestionController.class);
    
    // TODO: Add parameter to rests!
    private int amountOfChoices = 4;

    @Autowired
    private QuestionRepository repo;

    @Autowired
    private QuestionPreparator preparator;

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
        List<QuestionJSON> jsonToSend = new ArrayList<>();
        List<Question> questions = repo.findAll();

        RandomItemsFromList<Question> itemsGenerator = new RandomItemsFromList<>(amount, questions);
        try {
            for (Question question : itemsGenerator.getRandomItems()) {
                jsonToSend.add(preparator.createQuestion(question, amountOfChoices));
            }
        } catch (NotEnoughItemsOnListException e) {
            String message = String.format("There is not enough elements on the list. There is %d, but should be at least %d.",
                    e.getItemsOnList(), e.getHowManyItemsToChoose());
            throw new Exception(message, e);
        }

        return jsonToSend;
    }

    /**
     * Example: localhost:port/questions/20/Starozytnosc,Sredniowiecze
     * 
     * @param amount
     * @param categories
     * @return
     */
    @GetMapping("/questions/{amount}/{categories}")
    List<Question> getQuestionsFromSpecifiedCategories(@PathVariable Long amount, @PathVariable String[] categories) {
        log.info("Parameter 'amount': " + amount);
        log.info("Parameter 'categories': " + Arrays.toString(categories));
        throw new UnsupportedOperationException("Not supported yet!");
    }

}
