package objet;

public record Personne(String nom) {
	@Override
	public String toString() {
		return nom;
	}
}
