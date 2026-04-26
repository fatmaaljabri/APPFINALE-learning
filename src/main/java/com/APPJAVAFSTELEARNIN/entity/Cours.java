package com.APPJAVAFSTELEARNIN.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String categorie;

    @Enumerated(EnumType.STRING)
    private Niveau niveau;

    private String imageUrl;

    private boolean actif;

    private LocalDateTime dateCreation;

    @ManyToOne
    @JoinColumn(name = "formateur_id")
    private Utilisateur formateur;
}