package com.adam.stan.model;

import java.util.ArrayList;
import java.util.List;

public class AnswersList {
    private List<Answer> answers = new ArrayList<>();

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
