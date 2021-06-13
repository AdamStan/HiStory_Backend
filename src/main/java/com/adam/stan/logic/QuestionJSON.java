package com.adam.stan.logic;

import java.util.ArrayList;
import java.util.List;

import com.adam.stan.model.Answer;
import com.adam.stan.model.Question;

public class QuestionJSON {
    private String content;
    private String correctAnswer;
    private List<String> otherAnswers = new ArrayList<>();

    public QuestionJSON(Question question) {
        content = question.getContent();
        correctAnswer = question.getCorrectAnswer().getText();
    }

    public void addToOtherAnswers(Answer ans) {
        otherAnswers.add(ans.getText());
    }

    @Override
    public String toString() {
        return "QuestionJSON [content=" + content + ", correctAnswer=" + correctAnswer + "]";
    }

    public String getContent() {
        return content;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public List<String> getOtherAnswers() {
        return otherAnswers;
    }

}
