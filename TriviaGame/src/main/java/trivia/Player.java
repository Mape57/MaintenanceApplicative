package trivia;

public class Player {
	private String playerName;
	private int place;
	private int purse;
	private boolean inPenaltyBox;

	public Player(String playerName) {
		this.playerName = playerName;
		this.place = 1;
		this.purse = 0;
		this.inPenaltyBox = false;
	}

	public int getPlace() {
		return place;
	}

	public void setPlace(int place) {
		this.place = place;
	}

	public int getPurse() {
		return purse;
	}

	public void setPurse(int purse) {
		this.purse = purse;
	}

	public boolean isInPenaltyBox() {
		return inPenaltyBox;
	}

	public void setInPenaltyBox(boolean inPenaltyBox) {
		this.inPenaltyBox = inPenaltyBox;
	}

	@Override
	public String toString() {
		return playerName;
	}
}
