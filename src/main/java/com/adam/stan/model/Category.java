package com.adam.stan.model;

public class Category {
    private long id;
    private String name;
    private String category;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category [ID=" + id + ", name=" + name + ", category=" + category + "]";
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
