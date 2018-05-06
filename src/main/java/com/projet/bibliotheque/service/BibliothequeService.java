package com.projet.bibliotheque.service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.bibliotheque.entity.Livre;
import com.projet.bibliotheque.entity.Utilisateur;
import com.projet.bibliotheque.repository.LivreRepository;
import com.projet.bibliotheque.repository.UtilisateurRepository;

@Service
@Transactional(rollbackOn = Exception.class)
public class BibliothequeService {

	@Autowired
	private UtilisateurRepository utilisateurRepository;

	@Autowired
	private LivreRepository livreRepository;

	public Livre emprunterLivre(Long idUtilisateur, Long idLivre) throws Exception {
		LocalDateTime localDateTime = LocalDateTime.now();
		Utilisateur utilisateur = utilisateurRepository.findOne(idUtilisateur);
		Livre livre = livreRepository.findOne(idLivre);

		if (utilisateur != null) {

			if (livre != null) {

				if (livre.isDisponible()) {
					livre.setUtilisateur(utilisateur);
					livre.setDateEmprunt(localDateTime);
					livre.setDisponible(false);
					return livre;
				} else {
					throw new Exception("Le livre n'est pas disponible !");
				}
			} else {
				throw new Exception("Le livre n'existe pas !");
			}
		} else {
			throw new Exception("L'utilisateur n'existe pas !");
		}
	}

	public Livre rendreLivre(Long idUtilisateur, Long idLivre) throws Exception {
		Utilisateur utilisateur = utilisateurRepository.findOne(idUtilisateur);
		Livre livre = livreRepository.recupererLivreParUtilisateur(idUtilisateur, idLivre);

		if (utilisateur != null) {

			if (livre != null) {
				livre.setDateEmprunt(null);
				livre.setUtilisateur(null);
				livre.setDisponible(true);
				return livre;
			} else {
				throw new Exception("Le livre n'existe pas !");
			}
		} else {
			throw new Exception("L'utilisateur n'existe pas !");
		}

	}

}
