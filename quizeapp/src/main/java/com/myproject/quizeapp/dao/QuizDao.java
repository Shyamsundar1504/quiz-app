package com.myproject.quizeapp.dao;

import com.myproject.quizeapp.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz,Integer> {
}
