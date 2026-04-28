package com.APPJAVAFSTELEARNINservice;

import com.APPJAVAFSTELEARNIN.entity.*;
import com.APPJAVAFSTELEARNIN.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class InscriptionService {

    @Autowired
    private InscriptionRepository inscriptionRepository;
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private CoursRepository coursRepository;

    public Inscription inscrire(Long apprenantId, Long coursId) {
        Utilisateur apprenant = utilisateurRepository.findById(apprenantId).orElseThrow();
        Cours cours = coursRepository.findById(coursId).orElseThrow();

        Inscription inscription = Inscription.builder()
                .apprenant(apprenant)
                .cours(cours)
                .dateInscription(LocalDate.now())
                .statut(StatutInscription.EN_COURS)
                .build();

        return inscriptionRepository.save(inscription);
    }

    public List<Inscription> getMesCours(Long apprenantId) {
        Utilisateur apprenant = utilisateurRepository.findById(apprenantId).orElseThrow();
        return inscriptionRepository.findByApprenant(apprenant);
    }
}