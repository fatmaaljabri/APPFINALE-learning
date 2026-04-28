package com.APPJAVAFSTELEARNINservice;

import com.APPJAVAFSTELEARNIN.entity.Cours;
import com.APPJAVAFSTELEARNIN.repository.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CoursService {

    @Autowired
    private CoursRepository coursRepository;

    public Page<Cours> getCataloguePublic(Pageable pageable) {
        return coursRepository.findByActifTrue(pageable);
    }

    public List<Cours> findAll() {
        return coursRepository.findAll();
    }

    public Cours findById(Long id) {
        return coursRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cours non trouvé : " + id));
    }

    public Cours creer(Cours cours, MultipartFile file) throws IOException {
        if (file != null && !file.isEmpty()) {
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Path uploadDir = Paths.get("uploads");
            if (!Files.exists(uploadDir)) {
                Files.createDirectories(uploadDir);
            }
            Files.write(uploadDir.resolve(fileName), file.getBytes());
            cours.setImageUrl(fileName);
        }
        cours.setActif(true);
        cours.setDateCreation(LocalDateTime.now());
        return coursRepository.save(cours);
    }

    public Cours modifier(Long id, Cours coursModifie, MultipartFile file) throws IOException {
        Cours existing = findById(id);
        existing.setTitre(coursModifie.getTitre());
        existing.setDescription(coursModifie.getDescription());
        existing.setCategorie(coursModifie.getCategorie());
        existing.setNiveau(coursModifie.getNiveau());
        if (file != null && !file.isEmpty()) {
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Path uploadDir = Paths.get("uploads");
            if (!Files.exists(uploadDir)) {
                Files.createDirectories(uploadDir);
            }
            Files.write(uploadDir.resolve(fileName), file.getBytes());
            existing.setImageUrl(fileName);
        }
        return coursRepository.save(existing);
    }

    public void supprimer(Long id) {
        coursRepository.deleteById(id);
    }
}