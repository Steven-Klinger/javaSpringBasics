package com.projet.bibliotheque.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class LivreInDto {

	@NotNull
	@Size(min = 3)
	private String nom;

	@NotNull
	@Size(min = 8)
	private String auteur;

	@NotNull
	@Size(min = 8)
	private String resume;

}
