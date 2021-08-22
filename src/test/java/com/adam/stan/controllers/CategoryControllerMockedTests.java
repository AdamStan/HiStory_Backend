package com.adam.stan.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Tests inspired from: https://spring.io/guides/gs/testing-web/
 * @author Adam
 *
 */
@SpringBootTest
@AutoConfigureMockMvc
class CategoryControllerMockedTests {
    @Autowired
    private MockMvc mocked;

    @Test
    void categoryControllerShouldReturn() throws Exception {
        mocked.perform(get("/all/categories")).andDo(print()).andExpect(status().isOk());
    }

}
