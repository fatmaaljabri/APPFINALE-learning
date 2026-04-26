package com.APPJAVAFSTELEARNIN.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReponseApprenant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int reponseChoisie;

    private double score;

    @ManyToOne
    @JoinColumn(name = "apprenant_id")
    private Utilisateur apprenant;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
}


