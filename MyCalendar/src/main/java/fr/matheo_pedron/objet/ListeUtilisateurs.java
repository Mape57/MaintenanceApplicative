package fr.matheo_pedron.objet;

import java.util.List;

public record ListeUtilisateurs(List<Utilisateur> utilisateurs) {
	public void ajouterUtilisateur(Utilisateur utilisateur) {
		utilisateurs.add(utilisateur);
	}

	public boolean contains(Utilisateur utilisateur) {
		return utilisateurs.contains(utilisateur);
	}
}
