package com.adam.stan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "answers")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    private String text;
    @OneToOne(mappedBy = "correctAnswer")
    @JsonIgnore
    private Question question;
    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private AnswerType type;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
    
    public Answer() {
    }

    public Answer(String text, Question question, Category cat, AnswerType type) {
        this.text = text;
        this.question = question;
        this.type = type;
        this.category = cat;
    }

    @Override
    public String toString() {
        return "Answer [ID=" + ID + ", text=" + text + ", type=" + type + "]";
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer iD) {
        ID = iD;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public AnswerType getType() {
        return type;
    }

    public void setType(AnswerType type) {
        this.type = type;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
