package com.adam.stan.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CategorySearchStringBuilderTest {

    @Test
    void testGetCategorySearchString() {
        var builder = new CategorySearchStringBuilder();
        String[] categories = {"cat1", "cat2"};
        var query = builder.getCategorySearchString(categories);
        Assertions.assertEquals(query, "category=cat1&category=cat2&");
    }
}
