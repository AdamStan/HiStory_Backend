package com.adam.stan.logic;

import java.util.List;

public interface QuestionPreparator {
    void setNumberOfQuestions(int amount);

    List<QuestionJSON> getProperQuestions();
}
