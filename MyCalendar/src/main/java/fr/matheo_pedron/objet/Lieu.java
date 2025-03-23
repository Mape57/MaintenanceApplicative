package fr.matheo_pedron.objet;

public record Lieu(String lieu) {
	@Override
	public String toString() {
		return lieu;
	}
}
