package objet;

public record Lieu(String lieu) {
	@Override
	public String toString() {
		return lieu;
	}
}
