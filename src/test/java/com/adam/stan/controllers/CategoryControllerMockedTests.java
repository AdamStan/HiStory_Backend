package com.adam.stan.controllers;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.adam.stan.clients.CategoryClient;
import com.adam.stan.config.Database;

@SpringBootTest
@AutoConfigureMockMvc
class CategoryControllerMockedTests {

    private MockMvc mocked;
    private final Database database = new Database();
    @Mock
    private CategoryClient client;
    @InjectMocks
    private CategoryController categoryController;
    
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mocked = MockMvcBuilders.standaloneSetup(categoryController).build();
        when(client.getAllCategories()).thenReturn(database.getCategories());
    }
    
    @Test
    void testGetAllCategories() throws Exception {
        MvcResult result = mocked.perform(get("/v1/categories")).andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        String body = result.getResponse().getContentAsString();
        assertTrue(body.equals("[\"cat1\",\"cat2\"]"));
    }
}
