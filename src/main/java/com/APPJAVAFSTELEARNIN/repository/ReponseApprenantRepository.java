package com.APPJAVAFSTELEARNIN.repository;


import com.APPJAVAFSTELEARNIN.entity.ReponseApprenant;
import com.APPJAVAFSTELEARNIN.entity.Utilisateur;
import com.APPJAVAFSTELEARNIN.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReponseApprenantRepository extends JpaRepository<ReponseApprenant, Long> {

    List<ReponseApprenant> findByApprenantAndQuestion(Utilisateur apprenant, Question question);

    // Score total d’un apprenant dans un quiz
    @Query("""
        SELECT SUM(r.score)
        FROM ReponseApprenant r
        WHERE r.apprenant = :apprenant
        AND r.question.quiz.id = :quizId
    """)
    Double calculerScoreTotal(Utilisateur apprenant, Long quizId);
}