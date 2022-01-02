package com.adam.stan.model;

public class DirectCategory {
    private long id;
    private String category;

    public DirectCategory() {
    }

    public DirectCategory(String name) {
        this.category = name;
    }

    @Override
    public String toString() {
        return "Category [ID=" + id + ", category=" + category + "]";
    }

    public long getId() {
        return id;
    }

    public void setId(long iD) {
        id = iD;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
