package com.projet.bibliotheque.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Livre {

	@Id
	@Column(name = "id_livre")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nom")
	private String nom;

	@Column(name = "resume")
	private String resume;

	@Column(name = "auteur")
	private String auteur;

	@Column(name = "date_emprunt")
	private LocalDateTime dateEmprunt;

	@Column(name = "is_disponible")
	private boolean isDisponible;

	@ManyToOne
	@JoinColumn(name = "id_utilisateur")
	private Utilisateur utilisateur;

}
