package com.APPJAVAFSTELEARNIN.entity;


	import jakarta.persistence.*;
	import lombok.*;

	import java.time.LocalDateTime;

	@Entity
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public class ProgressionLecon {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private boolean completee;

	    private LocalDateTime dateCompletion;

	    @ManyToOne
	    @JoinColumn(name = "apprenant_id")
	    private Utilisateur apprenant;

	    @ManyToOne
	    @JoinColumn(name = "lecon_id")
	    private Lecon lecon;
	}


