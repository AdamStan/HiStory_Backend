package com.adam.stan.logic;

import java.util.List;

import com.adam.stan.clients.AnswerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adam.stan.model.Answer;
import com.adam.stan.model.AnswerType;
import com.adam.stan.model.Question;
import com.adam.stan.util.RandomItemsFromList;
import com.adam.stan.util.exceptions.NotEnoughItemsOnListException;

@Service
public class QuestionPreparationImpl implements QuestionPreparation {
    private AnswerClient client;

    @Autowired
    public void setClient(AnswerClient client) {
        this.client = client;
    }

    @Override
    public QuestionJSON createQuestion(Question question, int amountOfChoices) throws NotEnoughItemsOnListException {
        QuestionJSON jsonObject = new QuestionJSON(question);
        AnswerType type = question.getCorrect_answer().getType();
        // TODO: and category!
        List<Answer> answers = client.getAnswersByType(type.getName());

        RandomItemsFromList<Answer> itemsGenerator = new RandomItemsFromList<>(amountOfChoices, answers);
        List<Answer> chosenAnswers = itemsGenerator.getRandomItems();
        chosenAnswers.forEach(answer -> jsonObject.addToOtherAnswers(answer));

        return jsonObject;
    }

}
