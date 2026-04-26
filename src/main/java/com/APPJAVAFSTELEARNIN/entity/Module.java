package com.APPJAVAFSTELEARNIN.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;

    private String description;

    private int ordre;

    @ManyToOne
    @JoinColumn(name = "cours_id")
    private Cours cours;
}