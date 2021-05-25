package com.adam.stan.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import com.adam.stan.model.Answer;
import com.adam.stan.model.Category;
import com.adam.stan.model.Question;
import com.adam.stan.repositories.QuestionRepository;

public class QuestionPreparatorImpl implements QuestionPreparator {

    private Random rand = new Random();
    private int questionsNumber = 20;

    private List<Question> questions;

    @Override
    public void setNumberOfQuestions(int amount) {
        questionsNumber = amount;
    }

    @Override
    public List<QuestionJSON> getProperQuestions() {
        List<QuestionJSON> questionsToSend = new ArrayList<>();
        for (int i = 0; i < questionsNumber; i++) {
            int index = rand.nextInt(questions.size());
            Question randQuestion = questions.get(index);
            questionsToSend.add(new QuestionJSON(randQuestion));
        }
        return questionsToSend;
    }

}
