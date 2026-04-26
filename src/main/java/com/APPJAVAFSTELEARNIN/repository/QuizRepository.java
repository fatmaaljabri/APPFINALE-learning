package com.APPJAVAFSTELEARNIN.repository;


import com.APPJAVAFSTELEARNIN.entity.Quiz;
import com.APPJAVAFSTELEARNIN.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

    Optional<Quiz> findByModule(Module module);
}
