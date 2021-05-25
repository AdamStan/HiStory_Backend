package com.adam.stan.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.adam.stan.model.Category;
import com.adam.stan.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    @Query("select q from Question q where q.category in :cats")
    List<Question> findAllQuestionsFromCategories(@Param("cats")Category... categories);
}
