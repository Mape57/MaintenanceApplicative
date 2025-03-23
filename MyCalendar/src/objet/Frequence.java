package objet;

public record Frequence(int frequence) {
	@Override
	public String toString() {
		return String.valueOf(frequence);
	}
}
