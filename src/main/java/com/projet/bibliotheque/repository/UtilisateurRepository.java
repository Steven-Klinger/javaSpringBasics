package com.projet.bibliotheque.repository;

import org.springframework.data.repository.CrudRepository;

import com.projet.bibliotheque.entity.Utilisateur;

public interface UtilisateurRepository extends CrudRepository<Utilisateur, Long> {

	public Iterable<Utilisateur> findAllByNom(String nom);

	public Utilisateur findByEmail(String email);

}
