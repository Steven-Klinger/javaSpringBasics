package com.projet.bibliotheque.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projet.bibliotheque.converter.UtilisateurInDtoConverter;
import com.projet.bibliotheque.dto.UtilisateurInDto;
import com.projet.bibliotheque.entity.Utilisateur;
import com.projet.bibliotheque.service.UtilisateurService;

@RestController
public class UtilisateurController {

	@Autowired
	private UtilisateurService utilisateurService;

	@Autowired
	private UtilisateurInDtoConverter utilisateurInDtoConverter;

	@PostMapping("/creerutilisateur")
	public Utilisateur creerUtilisateur(@Valid @RequestBody UtilisateurInDto utilisateurInDto) {
		Utilisateur utilisateur = utilisateurInDtoConverter.convertirUtilisateurInDtoEnUtilisateur(utilisateurInDto);
		return utilisateurService.creerUtilisateur(utilisateur);
	}

	@GetMapping("/recupererutilisateurs")
	public Iterable<Utilisateur> recupererUtilisateur() {
		return utilisateurService.recupererUtilisateurs();
	}

	@GetMapping("/recupererutilisateurparnom/{nom}")
	public Iterable<Utilisateur> recupererUtilisateurParNom(@PathVariable String nom) {
		return utilisateurService.recupererUtilisateurParNom(nom);
	}

}
