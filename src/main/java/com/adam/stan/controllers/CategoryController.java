package com.adam.stan.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adam.stan.model.Category;
import com.adam.stan.repositories.CategoryRepository;

@RestController
public class CategoryController {
    @Autowired
    private CategoryRepository catRepo;

    @GetMapping("/all/categories")
    List<Category> allCategories() {
        return catRepo.findAll();
    }

}
