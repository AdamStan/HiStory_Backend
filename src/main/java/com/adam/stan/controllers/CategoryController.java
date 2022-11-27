package com.adam.stan.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adam.stan.clients.CategoryClient;
import com.adam.stan.model.Category;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/v1")
public class CategoryController {
    private static final Logger log = LoggerFactory.getLogger(QuestionController.class);
    @Autowired
    private CategoryClient client;

    @GetMapping("/categories")
    public List<String> getAllCategories() {
        log.info("Getting all categories");
        List<Category> categories = client.getAllCategories();
        log.info("Categories: " + categories);
        return categories.stream()
                .map(cat -> cat.getPeriod())
                .distinct()
                .collect(Collectors.toList());
    }
}
