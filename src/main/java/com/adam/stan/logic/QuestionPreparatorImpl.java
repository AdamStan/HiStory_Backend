package com.adam.stan.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adam.stan.model.Answer;
import com.adam.stan.model.AnswerType;
import com.adam.stan.model.Question;
import com.adam.stan.repositories.AnswerRepository;
import com.adam.stan.util.RandomItemsFromList;
import com.adam.stan.util.exceptions.NotEnoughItemsOnListException;

@Service
public class QuestionPreparatorImpl implements QuestionPreparator {

    @Autowired
    private AnswerRepository repo;

    @Override
    public QuestionJSON createQuestion(Question question, int amountOfChoices) throws Exception {
        QuestionJSON jsonObject = new QuestionJSON(question);
        AnswerType type = question.getCorrectAnswer().getType();
        List<Answer> answers = repo.findByType(type);

        RandomItemsFromList<Answer> itemsGenerator = new RandomItemsFromList<>(amountOfChoices, answers);
        try {
            List<Answer> chosenAnswers = itemsGenerator.getRandomItems();
            chosenAnswers.forEach(answer -> jsonObject.addToOtherAnswers(answer));
        } catch (NotEnoughItemsOnListException e) {
            String message = String.format("There is not enough answers from category: %s", type.getName());
            throw new Exception(message, e);
        }

        return jsonObject;
    }

}
