package com.adam.stan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "answers")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String answer;
    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private AnswerType type;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
    
    public Answer() {
    }

    public Answer(String text, Category cat, AnswerType type) {
        this.answer = text;
        this.type = type;
        this.category = cat;
    }

    @Override
    public String toString() {
        return "Answer [id=" + id + ", text=" + answer + ", type=" + type + "]";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String text) {
        this.answer = text;
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
