package com.projet.bibliotheque.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.projet.bibliotheque.entity.Livre;

public interface LivreRepository extends CrudRepository<Livre, Long> {

	public Livre findAllByNom(String nom);

	@Query("SELECT l FROM Livre l WHERE l.utilisateur.id = ?1 AND l.id = ?2")
	public Livre recupererLivreParUtilisateur(Long idUtilisateur, Long idLivre);
}
