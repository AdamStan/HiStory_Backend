package com.adam.stan.logic;

import com.adam.stan.model.Question;

public interface QuestionPreparation {
    QuestionDto createQuestion(Question question, int amountOfChoices);
}
