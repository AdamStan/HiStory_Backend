package com.adam.stan.config;

import com.adam.stan.model.Answer;
import com.adam.stan.model.AnswerType;
import com.adam.stan.model.Category;
import com.adam.stan.model.Question;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Answer> answers = new ArrayList<>();
    private List<Question> questions = new ArrayList<>();

    public Database() {
        initDatabase();
    }

    public void initDatabase() {
        Category category = new Category("cat1");
        Category cat2 = new Category("cat2");

        AnswerType type1 = new AnswerType("type1");
        createQuestions(0, 100, category, type1);
        createQuestions(100, 100, cat2, type1);
    }

    private void createQuestions(int startIndex, int amount, Category category, AnswerType type) {
        for (int i = startIndex; i < startIndex + amount; i++) {
            Question q = createBaseQuestionAnswer(category, type, i);
            questions.add(q);
        }
    }

    private Question createBaseQuestionAnswer(Category category, AnswerType type, int i) {
        Question q1 = new Question("Question" + i + "?", null);
        Answer a1 = new Answer("Answer" + i, category, type);
        q1.setCorrect_answer(a1);
        answers.add(a1);
        return q1;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
