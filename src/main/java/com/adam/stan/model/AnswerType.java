package com.adam.stan.model;

import java.util.Objects;

public class AnswerType {
    private long id;
    private String name;

    public AnswerType() {
    }

    public AnswerType(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
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
        return Objects.equals(id, other.id) && Objects.equals(name, other.name);
    }

    @Override
    public String toString() {
        return "AnswerType [ID=" + id + ", name=" + name + "]";
    }

    public long getId() {
        return id;
    }

    public void setId(long iD) {
        id = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
