CREATE TABLE Utilisateur
(
	id_utilisateur INT PRIMARY KEY AUTO_INCREMENT,
	nom VARCHAR(100) NOT NULL,
	prenom VARCHAR(100) NOT NULL,
	adresse VARCHAR(100) NOT NULL,
	numero_telephone VARCHAR(100) NOT NULL,
	email VARCHAR(100) NOT NULL UNIQUE,
);

CREATE TABLE Livre
(
	id_livre INT PRIMARY KEY AUTO_INCREMENT,
	nom VARCHAR(100) NOT NULL,
	auteur VARCHAR(100) NOT NULL,
	resume VARCHAR(255) NOT NULL,
	date_emprunt TIMESTAMP,
	is_disponible BOOLEAN NOT NULL,
	id_utilisateur INT,
);

ALTER TABLE Livre
ADD CONSTRAINT fk_id_utilisateur_livre FOREIGN KEY (id_utilisateur) REFERENCES Utilisateur(id_utilisateur);