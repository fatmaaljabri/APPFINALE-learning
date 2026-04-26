package com.APPJAVAFSTELEARNIN.entity;


	import jakarta.persistence.*;
	import lombok.*;

	import java.time.LocalDate;

	@Entity
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public class Inscription {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private LocalDate dateInscription;

	    @Enumerated(EnumType.STRING)
	    private StatutInscription statut;

	    @ManyToOne
	    @JoinColumn(name = "apprenant_id")
	    private Utilisateur apprenant;

	    @ManyToOne
	    @JoinColumn(name = "cours_id")
	    private Cours cours;
	}

