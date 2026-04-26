package com.APPJAVAFSTELEARNINservice;


import com.APPJAVAFSTELEARNIN.entity.Cours;
import com.APPJAVAFSTELEARNIN.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.*;

@Service
public class CoursService {

    @Autowired
    private CoursRepository coursRepository;

    // Catalogue public
    public Page<Cours> getCataloguePublic(Pageable pageable) {
        return coursRepository.findByActifTrue(pageable);
    }

    // Création avec upload image
    public Cours creer(Cours cours, org.springframework.web.multipart.MultipartFile file) throws IOException {

        if (file != null && !file.isEmpty()) {
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Path path = Paths.get("uploads/" + fileName);
            Files.write(path, file.getBytes());
            cours.setImageUrl(fileName);
        }

        cours.setActif(true);
        cours.setDateCreation(java.time.LocalDateTime.now());

        return coursRepository.save(cours);
    }

    public Cours modifier(Cours cours) {
        return coursRepository.save(cours);
    }

    public void supprimer(Long id) {
        coursRepository.deleteById(id);
    }
}