package com.adam.stan.model;

public class Question {
    private long id;
    private String text;
    private Answer correct_answer;

    public Question() {
    }

    public Question(String content, Answer correctAnswer) {
        this.text = content;
        this.correct_answer = correctAnswer;
    }

    @Override
    public String toString() {
        return "Question-" + id + ": " + text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Answer getCorrect_answer() {
        return correct_answer;
    }

    public void setCorrect_answer(Answer correct_answer) {
        this.correct_answer = correct_answer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
