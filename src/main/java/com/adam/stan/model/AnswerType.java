package com.adam.stan.model;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "answers_types")
public class AnswerType {
    @Id
    @GeneratedValue
    private Integer ID;
    private String name;
    @OneToMany(mappedBy = "type")
    @JsonIgnore
    private Set<Answer> answers;

    public AnswerType() {
    }

    public AnswerType(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, answers, name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AnswerType)) {
            return false;
        }
        AnswerType other = (AnswerType) obj;
        return Objects.equals(ID, other.ID) && Objects.equals(answers, other.answers)
                && Objects.equals(name, other.name);
    }

    @Override
    public String toString() {
        return "AnswerType [ID=" + ID + ", name=" + name + "]";
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer iD) {
        ID = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }

}
