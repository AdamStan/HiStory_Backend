package com.adam.stan.model;

public class Question {
    private long id;
    private String content;
    private Answer correctAnswer;

    public Question() {
    }

    public Question(String content, Answer correctAnswer) {
        this.content = content;
        this.correctAnswer = correctAnswer;
    }

    @Override
    public String toString() {
        return "Question-" + id + ": " + content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Answer getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(Answer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
