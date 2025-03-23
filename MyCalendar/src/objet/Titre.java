package objet;

public record Titre(String titre) {
	@Override
	public String toString() {
		return titre;
	}
}
