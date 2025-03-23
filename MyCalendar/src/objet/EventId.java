package objet;

public record EventId(int id) {
	private static int MAX_ID = 0;

	public EventId() {
		this(MAX_ID++);
	}
}
