package com.projet.bibliotheque.converter;

import org.springframework.stereotype.Component;

import com.projet.bibliotheque.dto.UtilisateurInDto;
import com.projet.bibliotheque.entity.Utilisateur;

@Component
public class UtilisateurInDtoConverter {

	public Utilisateur convertirUtilisateurInDtoEnUtilisateur(final UtilisateurInDto utilisateurInDto) {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setEmail(utilisateurInDto.getEmail());
		utilisateur.setAdresse(utilisateurInDto.getAdresse());
		utilisateur.setNom(utilisateurInDto.getNom());
		utilisateur.setNumeroTelephone(utilisateurInDto.getNumeroTelephone());
		utilisateur.setPrenom(utilisateurInDto.getPrenom());

		return utilisateur;
	}

}
