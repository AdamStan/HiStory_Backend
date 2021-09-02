package com.adam.stan.logic;

import com.adam.stan.model.Question;

public interface QuestionPreparator {
    QuestionJSON createQuestion(Question question, int amountOfChoices) throws Exception;
}
