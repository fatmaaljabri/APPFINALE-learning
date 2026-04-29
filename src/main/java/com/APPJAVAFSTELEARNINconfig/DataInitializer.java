package com.APPJAVAFSTELEARNINconfig;

import com.APPJAVAFSTELEARNIN.entity.*;
import com.APPJAVAFSTELEARNIN.entity.Role;
import com.APPJAVAFSTELEARNIN.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initData(UtilisateurRepository userRepo,
                               CoursRepository coursRepo,
                               PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepo.count() == 0) {
                Utilisateur admin = Utilisateur.builder()
                        .nom("Admin")
                        .email("admin@test.com")
                        .motDePasse(passwordEncoder.encode("1234"))
                        .role(Role.ADMIN)
                        .build();

                Utilisateur formateur = Utilisateur.builder()
                        .nom("Formateur")
                        .email("formateur@test.com")
                        .motDePasse(passwordEncoder.encode("1234"))
                        .role(Role.FORMATEUR)
                        .build();

                Utilisateur apprenant = Utilisateur.builder()
                        .nom("Apprenant")
                        .email("apprenant@test.com")
                        .motDePasse(passwordEncoder.encode("1234"))
                        .role(Role.APPRENANT)
                        .build();

                userRepo.save(admin);
                userRepo.save(formateur);
                userRepo.save(apprenant);

                Cours cours = Cours.builder()
                        .titre("Spring Boot")
                        .description("Cours complet Spring")
                        .categorie("Programmation")
                        .niveau(Niveau.DEBUTANT)
                        .actif(true)
                        .formateur(formateur)
                        .build();

                coursRepo.save(cours);
            }
        };
    }
}