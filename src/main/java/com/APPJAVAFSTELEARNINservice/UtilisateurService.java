package com.APPJAVAFSTELEARNINservice;


import com.APPJAVAFSTELEARNIN.entity.Utilisateur;
import com.APPJAVAFSTELEARNIN.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurService implements UserDetailsService {

    @Autowired
    private UtilisateurRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) {

        Utilisateur user = repo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return User.builder()
                .username(user.getEmail())
                .password(user.getMotDePasse())
                .roles(user.getRole().name())
                .build();
    }

    // Inscription
    public Utilisateur inscrireNouvelUtilisateur(Utilisateur utilisateur) {

        utilisateur.setMotDePasse(passwordEncoder.encode(utilisateur.getMotDePasse()));

        return repo.save(utilisateur);
    }}

