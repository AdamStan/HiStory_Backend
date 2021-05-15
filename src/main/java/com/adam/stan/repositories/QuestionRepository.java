package com.adam.stan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adam.stan.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

}
