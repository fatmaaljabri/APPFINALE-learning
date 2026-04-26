package com.APPJAVAFSTELEARNIN.repository;


import com.APPJAVAFSTELEARNIN.entity.ProgressionLecon;
import com.APPJAVAFSTELEARNIN.entity.Utilisateur;
import com.APPJAVAFSTELEARNIN.entity.Lecon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProgressionLeconRepository extends JpaRepository<ProgressionLecon, Long> {

    // Nombre de leçons complétées
    long countByApprenantAndLeconIn(Utilisateur apprenant, List<Lecon> lecons);

    // Calcul progression %
    @Query("""
        SELECT COUNT(pl) * 100.0 / :total
        FROM ProgressionLecon pl
        WHERE pl.apprenant = :apprenant
        AND pl.completee = true
        AND pl.lecon IN :lecons
    """)
    Double calculerProgression(Utilisateur apprenant, List<Lecon> lecons, long total);
}