package com.APPJAVAFSTELEARNIN.repository;


import com.APPJAVAFSTELEARNIN.entity.Question;
import com.APPJAVAFSTELEARNIN.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findByQuiz(Quiz quiz);
}