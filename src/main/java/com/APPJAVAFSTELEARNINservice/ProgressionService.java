package com.APPJAVAFSTELEARNINservice;


import com.APPJAVAFSTELEARNIN.entity.*;
import com.APPJAVAFSTELEARNIN.entity.Module;
import com.APPJAVAFSTELEARNIN.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProgressionService {

    @Autowired
    private ProgressionLeconRepository progressionRepo;

    @Autowired
    private LeconRepository leconRepo;

    @Autowired
    private ModuleRepository moduleRepo;

    @Autowired
    private UtilisateurRepository userRepo;

    // Marquer leçon comme complétée
    public void marquerLeconComplete(Long apprenantId, Long leconId) {

        Utilisateur user = userRepo.findById(apprenantId).orElseThrow();
        Lecon lecon = leconRepo.findById(leconId).orElseThrow();

        ProgressionLecon prog = ProgressionLecon.builder()
                .apprenant(user)
                .lecon(lecon)
                .completee(true)
                .dateCompletion(LocalDateTime.now())
                .build();

        progressionRepo.save(prog);
    }

    // Calcul %
    public double calculerPourcentage(Utilisateur apprenant, Cours cours) {

        List<Module> modules = moduleRepo.findByCours(cours);

        List<Lecon> lecons = modules.stream()
                .flatMap(m -> leconRepo.findByModule(m).stream())
                .toList();

        long total = lecons.size();
        if (total == 0) return 0;

        long completed = progressionRepo.countByApprenantAndLeconIn(apprenant, lecons);

        return (completed * 100.0) / total;
    }}
