package com.adam.stan.dto;

import java.util.ArrayList;
import java.util.List;

import com.adam.stan.model.Answer;
import com.adam.stan.model.Question;

public class QuestionDto {
    private String content;
    private String correctAnswer;
    private List<String> otherAnswers = new ArrayList<>();

    public QuestionDto(Question question) {
        content = question.getText();
        correctAnswer = question.getCorrect_answer().getAnswer();
    }

    public void addToOtherAnswers(Answer ans) {
        otherAnswers.add(ans.getAnswer());
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
