package com.adam.stan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adam.stan.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
