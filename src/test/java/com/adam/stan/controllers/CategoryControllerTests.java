package com.adam.stan.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.adam.stan.model.Category;

public class CategoryControllerTests extends ControllerTests {

    @Test
    public void getAllCategories() throws Exception {
        String uri = "/all/categories";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Category[] categories = super.mapFromJson(content, Category[].class);
        assertTrue(categories.length > 0);
    }

}