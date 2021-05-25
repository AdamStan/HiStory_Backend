package com.adam.stan.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adam.stan.model.Answer;
import com.adam.stan.model.AnswerType;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
   List<Answer> findByType(AnswerType type);
}
