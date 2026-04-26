package com.APPJAVAFSTELEARNIN.entity;


	import jakarta.persistence.*;
	import lombok.*;

	@Entity
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public class Question {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String texte;

	    private String choix1;
	    private String choix2;
	    private String choix3;
	    private String choix4;

	    // 1, 2, 3 ou 4
	    private int bonneReponse;

	    @ManyToOne
	    @JoinColumn(name = "quiz_id")
	    private Quiz quiz;
	}


