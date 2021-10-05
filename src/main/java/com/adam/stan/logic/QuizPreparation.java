package com.adam.stan.logic;

import com.adam.stan.model.Question;

import java.util.List;

public interface QuizPreparation {
    List<QuestionJSON> getQuiz(List<Question> allQuestions, int amountOfQuestions, int answersToChoice);
}
