package com.adam.stan.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.adam.stan.HiStoryQuestionsApplication;
/**
 * Was made from example:
 * https://www.tutorialspoint.com/spring_boot/spring_boot_rest_controller_unit_test.htm
 * @author adam
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = HiStoryQuestionsApplication.class)
@WebAppConfiguration
public abstract class ControllerTests {
    protected MockMvc mvc;
    @Autowired
    WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

}
