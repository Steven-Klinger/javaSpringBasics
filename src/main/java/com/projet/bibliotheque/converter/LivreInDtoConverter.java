package com.projet.bibliotheque.converter;

import org.springframework.stereotype.Component;

import com.projet.bibliotheque.dto.LivreInDto;
import com.projet.bibliotheque.entity.Livre;

@Component
public class LivreInDtoConverter {

	public Livre convertirLivreInDtoEnLivre(LivreInDto livreInDto) {
		Livre livre = new Livre();
		livre.setNom(livreInDto.getNom());
		livre.setAuteur(livreInDto.getAuteur());
		livre.setResume(livreInDto.getResume());
		livre.setDateEmprunt(null);
		livre.setUtilisateur(null);
		livre.setDisponible(true);
		return livre;
	}

}
