package com.projet.bibliotheque.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projet.bibliotheque.converter.LivreInDtoConverter;
import com.projet.bibliotheque.dto.LivreInDto;
import com.projet.bibliotheque.entity.Livre;
import com.projet.bibliotheque.service.BibliothequeService;
import com.projet.bibliotheque.service.LivreService;

@RestController
public class LivreController {

	@Autowired
	LivreService livreService;

	@Autowired
	LivreInDtoConverter livreInDtoConverter;

	@Autowired
	BibliothequeService bibliothequeService;

	@PostMapping("/creerlivre")
	public Livre creerLivre(@Valid @RequestBody LivreInDto livreInDto) {
		Livre livre = livreInDtoConverter.convertirLivreInDtoEnLivre(livreInDto);
		return livreService.creerLivre(livre);
	}

	@GetMapping("/recupererlivres")
	public Iterable<Livre> recupererLivres() {
		return livreService.recupererLivres();
	}

	@GetMapping("/recupererlivreparnom/{nom}")
	public Livre recupererLivreParNom(@PathVariable String nom) {
		return livreService.recupererLivreParNom(nom);
	}

	@GetMapping("/emprunterlivre/{idUtilisateur}/{idLivre}")
	public Livre emprunterLivre(@PathVariable Long idUtilisateur, @PathVariable Long idLivre) throws Exception {
		return bibliothequeService.emprunterLivre(idUtilisateur, idLivre);
	}

	@GetMapping("/rendrelivre/{idUtilisateur}/{idLivre}")
	public Livre rendreLivre(@PathVariable Long idUtilisateur, @PathVariable Long idLivre) throws Exception {
		return bibliothequeService.rendreLivre(idUtilisateur, idLivre);
	}
}
