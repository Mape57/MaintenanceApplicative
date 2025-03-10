package trivia;

public enum Categories {
	POP("Pop"),
	SCIENCE("Science"),
	SPORTS("Sports"),
	ROCK("Rock");

	private String categories;

	private Categories(String category) {
		this.categories = category;
	}

	public String toString() {
		return categories;
	}
}
