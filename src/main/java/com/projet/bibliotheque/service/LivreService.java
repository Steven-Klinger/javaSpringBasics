package com.projet.bibliotheque.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.bibliotheque.entity.Livre;
import com.projet.bibliotheque.repository.LivreRepository;

@Service
@Transactional(rollbackOn = Exception.class)
public class LivreService {

	@Autowired
	private LivreRepository livreRepository;

	public Livre creerLivre(Livre livre) {
		return livreRepository.save(livre);
	}

	public Iterable<Livre> recupererLivres() {
		return livreRepository.findAll();
	}

	public Livre recupererLivreParNom(String nom) {
		return livreRepository.findAllByNom(nom);
	}

	public Livre recupererLotParId(Long id) {
		return livreRepository.findOne(id);
	}
}
