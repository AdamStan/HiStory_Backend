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
    public QuestionJSON createQuestion(Question question, int amountOfChoices) throws NotEnoughItemsOnListException {
        QuestionJSON jsonObject = new QuestionJSON(question);
        AnswerType type = question.getCorrectAnswer().getType();
        List<Answer> answers = repo.findByType(type);

        RandomItemsFromList<Answer> itemsGenerator = new RandomItemsFromList<>(amountOfChoices, answers);
        List<Answer> chosenAnswers = itemsGenerator.getRandomItems();
        chosenAnswers.forEach(answer -> jsonObject.addToOtherAnswers(answer));

        return jsonObject;
    }

}
