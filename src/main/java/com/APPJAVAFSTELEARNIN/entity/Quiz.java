package com.APPJAVAFSTELEARNIN.entity;


	import jakarta.persistence.*;
	import lombok.*;

	@Entity
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public class Quiz {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String titre;

	    @ManyToOne
	    @JoinColumn(name = "module_id")
	    private Module module;
	}

