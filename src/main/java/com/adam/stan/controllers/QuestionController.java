package com.adam.stan.controllers;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.adam.stan.model.Question;
import com.adam.stan.repositories.QuestionRepository;

@RestController
public class QuestionController {
    private static final Logger log = LoggerFactory.getLogger(QuestionController.class);

    @Autowired
    private QuestionRepository repo;

    @GetMapping("/all/questions")
    List<Question> getAllQuestions() {
        return repo.findAll();
    }

    /**
     * Example: localhost:8080/questions/20
     * @param amount
     * @return
     * @throws Exception
     */
    @GetMapping("/questions/{amount}")
    List<Question> getQuestionsFromAllCategories(@PathVariable Long amount) 
            throws Exception {
        log.info("Parameter 'amount': " + amount);
        throw new UnsupportedOperationException("Not supported yet!");
    }
    
    /**
     * Example: localhost:8080/questions/20/Starozytnosc,Sredniowiecze
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
