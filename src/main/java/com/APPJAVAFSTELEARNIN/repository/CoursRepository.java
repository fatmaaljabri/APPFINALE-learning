package com.APPJAVAFSTELEARNIN.repository;
import 	com.APPJAVAFSTELEARNIN.entity.Cours;
import com.APPJAVAFSTELEARNIN.entity.Utilisateur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursRepository extends JpaRepository<Cours, Long> {

    // Catalogue public
    Page<Cours> findByActifTrue(Pageable pageable);

    // Recherche par titre
    Page<Cours> findByTitreContainingIgnoreCase(String titre, Pageable pageable);

    // Cours d’un formateur
    Page<Cours> findByFormateur(Utilisateur formateur, Pageable pageable);
}
