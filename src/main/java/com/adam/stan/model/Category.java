package com.adam.stan.model;

import java.util.Set;

public class Category {
    private long id;
    private String name;
    private Set<Answer> answers;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category [ID=" + id + ", name=" + name + "]";
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
