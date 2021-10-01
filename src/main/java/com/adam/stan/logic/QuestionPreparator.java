package com.adam.stan.logic;

import com.adam.stan.model.Question;
import com.adam.stan.util.exceptions.NotEnoughItemsOnListException;

public interface QuestionPreparator {
    QuestionJSON createQuestion(Question question, int amountOfChoices) throws NotEnoughItemsOnListException;
}
