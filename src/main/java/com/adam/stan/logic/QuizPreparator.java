package com.adam.stan.logic;

import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adam.stan.model.Question;
import com.adam.stan.util.RandomItemsFromList;
import com.adam.stan.util.exceptions.NotEnoughItemsOnListException;

@Component
public class QuizPreparator {
    private static final Logger log = Logger.getLogger(QuizPreparator.class);
    private QuestionPreparator preparator;

    @Autowired
    public void setPreparator(QuestionPreparator questionPreparator) {
        this.preparator = questionPreparator;
    }

    public List<QuestionJSON> getQuiz(List<Question> allQuestions, int amountOfQuestions, int answersToChoice) {
        List<QuestionJSON> jsonToSend = new ArrayList<>(amountOfQuestions);
        RandomItemsFromList<Question> itemsGenerator = new RandomItemsFromList<>(amountOfQuestions, allQuestions);
        try {
            for (Question question : itemsGenerator.getRandomItems()) {
                jsonToSend.add(preparator.createQuestion(question, answersToChoice));
            }
        } catch (NotEnoughItemsOnListException e) {
            String message = String.format("Not enough elements on list, elements: %d, values: %d", e.getItemsOnList(),
                    e.getHowManyItemsToChoose());
            log.error(message, e);
            throw new RuntimeException(message);
        }
        return jsonToSend;
    }

}