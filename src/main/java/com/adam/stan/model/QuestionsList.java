package com.adam.stan.model;

import java.util.ArrayList;
import java.util.List;

public class QuestionsList {
    private List<Question> questions = new ArrayList<>();

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
