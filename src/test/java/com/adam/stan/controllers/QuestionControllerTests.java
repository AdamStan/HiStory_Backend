package com.adam.stan.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.adam.stan.model.Question;
import com.adam.stan.util.JsonHelper;

class QuestionControllerTests extends ControllerTests {

    @Test
    void getAllQuestions() throws Exception {
        String uri = "/all/questions";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Question[] questions = JsonHelper.mapFromJson(content, Question[].class);
        assertTrue(questions.length > 0);
    }

    @Test
    void getNQuestions() throws Exception {
        int amount = 20;
        String uri = "/questions/" + amount;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Question[] questions = JsonHelper.mapFromJson(content, Question[].class);
        assertEquals(amount, questions.length);
    }

    @Test
    void get2CategoriesQuestions() throws Exception {
        int amount = 10;
        String categories = "Starozytnosc,Sredniowiecze";
        String uri = "/questions/" + amount + "/" + categories;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Question[] questions = JsonHelper.mapFromJson(content, Question[].class);
        assertEquals(amount, questions.length);
    }
}
