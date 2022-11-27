package com.adam.stan.model;

public class Category {
    private long id;
    private String period;
    private String details;

    public Category() {
    }

    public Category(String period, String details) {
        this.period = period;
        this.details = details;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Category [period=" + period + ", details=" + details + "]";
    }

}
