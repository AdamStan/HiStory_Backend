package com.adam.stan.logic;

import com.adam.stan.dto.QuestionDto;
import com.adam.stan.model.Question;
import com.adam.stan.util.RandomItemsFromList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class QuizPreparationImpl implements QuizPreparation{
    private QuestionPreparation questionPreparation;

    @Autowired
    public void setPreparation(QuestionPreparation questionPreparation) {
        this.questionPreparation = questionPreparation;
    }

    public List<QuestionDto> getQuiz(List<Question> allQuestions, int amountOfQuestions, int answersToChoice) {
        List<QuestionDto> questions = new ArrayList<>(amountOfQuestions);
        RandomItemsFromList<Question> itemsGenerator = new RandomItemsFromList<>(amountOfQuestions, allQuestions);
        for (Question question : itemsGenerator.getRandomItems()) {
            questions.add(questionPreparation.createQuestion(question, answersToChoice));
        }
        return questions;
    }

}
