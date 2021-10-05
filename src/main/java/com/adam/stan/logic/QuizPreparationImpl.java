package com.adam.stan.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adam.stan.model.Question;
import com.adam.stan.util.RandomItemsFromList;
import com.adam.stan.util.exceptions.NotEnoughItemsOnListException;

@Component
public class QuizPreparationImpl implements QuizPreparation{
    private static final Logger log = Logger.getLogger(QuizPreparationImpl.class.getName());
    private QuestionPreparation questionPreparation;

    @Autowired
    public void setPreparation(QuestionPreparation questionPreparation) {
        this.questionPreparation = questionPreparation;
    }

    public List<QuestionJSON> getQuiz(List<Question> allQuestions, int amountOfQuestions, int answersToChoice) {
        List<QuestionJSON> jsonToSend = new ArrayList<>(amountOfQuestions);
        RandomItemsFromList<Question> itemsGenerator = new RandomItemsFromList<>(amountOfQuestions, allQuestions);
        try {
            for (Question question : itemsGenerator.getRandomItems()) {
                jsonToSend.add(questionPreparation.createQuestion(question, answersToChoice));
            }
        } catch (NotEnoughItemsOnListException e) {
            String message = String.format("Not enough elements on list! There is %d elements, but should be %d or more!", e.getItemsOnList(),
                    e.getHowManyItemsToChoose());
            log.log(Level.FINEST, message, e);
            throw new RuntimeException(message);
        }
        return jsonToSend;
    }

}
