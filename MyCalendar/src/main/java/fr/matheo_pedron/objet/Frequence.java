package fr.matheo_pedron.objet;

public record Frequence(int frequence) {
	@Override
	public String toString() {
		return String.valueOf(frequence);
	}
}
