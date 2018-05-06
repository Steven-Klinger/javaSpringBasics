package com.projet.bibliotheque.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.bibliotheque.entity.Utilisateur;
import com.projet.bibliotheque.repository.UtilisateurRepository;

@Service
@Transactional(rollbackOn = Exception.class)
public class UtilisateurService {

	@Autowired
	private UtilisateurRepository utilisateurRepository;

	public Utilisateur creerUtilisateur(Utilisateur utilisateur) {
		return utilisateurRepository.save(utilisateur);
	}

	public Iterable<Utilisateur> recupererUtilisateurs() {
		return utilisateurRepository.findAll();
	}

	public Iterable<Utilisateur> recupererUtilisateurParNom(String nom) {
		return utilisateurRepository.findAllByNom(nom);
	}

	public Utilisateur recupererParEmail(String email) {
		return utilisateurRepository.findByEmail(email);
	}

}
