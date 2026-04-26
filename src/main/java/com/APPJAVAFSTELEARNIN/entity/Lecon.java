package com.APPJAVAFSTELEARNIN.entity;

	import jakarta.persistence.*;
	import lombok.*;

	@Entity
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public class Lecon {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String titre;

	    @Column(columnDefinition = "TEXT")
	    private String contenu;

	    private int ordre;

	    private int dureeMin;

	    @ManyToOne
	    @JoinColumn(name = "module_id")
	    private Module module;
	}


