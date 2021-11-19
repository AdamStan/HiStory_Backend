package com.adam.stan.util;

import org.springframework.stereotype.Component;

@Component
public class CategorySearchStringBuilder {

    public String getCategorySearchString(String[] categories) {
        StringBuilder builder = new StringBuilder();
        for (String cat : categories) {
            builder.append("category=");
            builder.append(cat);
            builder.append("&");
        }
        return builder.toString();
    }
}
