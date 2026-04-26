package com.APPJAVAFSTELEARNIN.repository;


import com.APPJAVAFSTELEARNIN.entity.Inscription;
import com.APPJAVAFSTELEARNIN.entity.Utilisateur;
import com.APPJAVAFSTELEARNIN.entity.Cours;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InscriptionRepository extends JpaRepository<Inscription, Long> {

    List<Inscription> findByApprenant(Utilisateur apprenant);

    Optional<Inscription> findByCoursAndApprenant(Cours cours, Utilisateur apprenant);
}