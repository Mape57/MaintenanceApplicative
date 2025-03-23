package fr.matheo_pedron.objet;

public record Titre(String titre) {
	@Override
	public String toString() {
		return titre;
	}
}
