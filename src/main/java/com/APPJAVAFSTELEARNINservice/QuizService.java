package com.APPJAVAFSTELEARNINservice;

import com.APPJAVAFSTELEARNINdto.QuizResultDTO;
import com.APPJAVAFSTELEARNIN.entity.*;
import com.APPJAVAFSTELEARNIN.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepo;

    @Autowired
    private QuestionRepository questionRepo;

    @Autowired
    private ReponseApprenantRepository reponseRepo;

    @Autowired
    private UtilisateurRepository userRepo;

    public Quiz getQuizParModule(Long moduleId) {
        return quizRepo.findById(moduleId).orElseThrow();
    }

    public QuizResultDTO soumettre(Map<Long, Integer> reponses, Long apprenantId) {

        Utilisateur user = userRepo.findById(apprenantId).orElseThrow();

        double score = 0;
        int total = reponses.size();

        for (Map.Entry<Long, Integer> entry : reponses.entrySet()) {

            Question question = questionRepo.findById(entry.getKey()).orElseThrow();
            int reponseChoisie = entry.getValue();

            double point = (question.getBonneReponse() == reponseChoisie) ? 1 : 0;
            score += point;

            ReponseApprenant rep = ReponseApprenant.builder()
                    .apprenant(user)
                    .question(question)
                    .reponseChoisie(reponseChoisie)
                    .score(point)
                    .build();

            reponseRepo.save(rep);
        }

        return new QuizResultDTO(apprenantId, score, total, (score * 100) / total, null);
    }
}
