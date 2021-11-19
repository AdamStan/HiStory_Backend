package com.adam.stan.logic;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.adam.stan.clients.AnswerClient;
import com.adam.stan.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adam.stan.model.Answer;
import com.adam.stan.model.AnswerType;
import com.adam.stan.model.Question;
import com.adam.stan.util.RandomItemsFromList;

@Service
public class QuestionPreparationImpl implements QuestionPreparation {
    private AnswerClient client;

    @Autowired
    public void setClient(AnswerClient client) {
        this.client = client;
    }

    @Override
    public QuestionDto createQuestion(Question question, int amountOfChoices) {
        QuestionDto jsonObject = new QuestionDto(question);
        AnswerType type = question.getCorrect_answer().getType();
        Category cat = question.getCorrect_answer().getCategory();
        List<Answer> answers = client.getAnswersByTypeAndCategory(type.getName(), cat.getName());

        RandomItemsFromList<Answer> itemsGenerator = new RandomItemsFromList<>(amountOfChoices, answers);
        List<Answer> chosenAnswers = itemsGenerator.getRandomItems();
        if (checkIfNotContainsCorrectAnswer(chosenAnswers, question.getCorrect_answer())) {
            chosenAnswers.remove(ThreadLocalRandom.current().nextInt(chosenAnswers.size()));
            chosenAnswers.add(question.getCorrect_answer());
        }
        chosenAnswers.forEach(jsonObject::addToOtherAnswers);

        return jsonObject;
    }

    private boolean checkIfNotContainsCorrectAnswer(List<Answer> chosenAnswers, Answer correct_answer) {
        return chosenAnswers.stream().noneMatch(ans -> ans.getAnswer().equals(correct_answer.getAnswer()));
    }

}
