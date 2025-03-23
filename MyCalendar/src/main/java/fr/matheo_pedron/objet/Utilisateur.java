package fr.matheo_pedron.objet;

public record Utilisateur(String nom, String motDePasse) {
	@Override
	public String toString() {
		return nom;
	}
}
