package com.adam.stan.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class QuestionControllerMockedTests {
    @Autowired
    private MockMvc mocked;

    @Test
    void questionControllerShouldReturn() throws Exception {
        mocked.perform(get("/v1/all/questions")).andDo(print())
           .andExpect(status().isOk());
    }

    @Test
    void questionControllerShouldReturn2() throws Exception {
        mocked.perform(get("/v1/questions/10")).andDo(print())
              .andExpect(status().isOk());
    }

    @Test
    void questionControllerShouldReturn3() throws Exception {
        mocked.perform(get("/v1/questions/20/cat2")).andDo(print())
              .andExpect(status().isOk());
    }

}
