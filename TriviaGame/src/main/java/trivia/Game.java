package trivia;

import java.util.*;

// REFACTOR ME
public class Game implements IGame {
	// circular
	ArrayList<Player> players = new ArrayList<>();

	HashMap<Categories, LinkedList<String>> questions = new HashMap<>();

	// remove and make it Player
	int currentPlayer = 0;
	// remove
	boolean isGettingOutOfPenaltyBox;

	public Game() {
		for (Categories categorie : Categories.values()) {
			LinkedList<String> questionsList = new LinkedList<>();
			for (int i = 0; i < 50; i++) {
				questionsList.addLast(categorie + " Question " + i);
			}
			questions.put(categorie, questionsList);
		}
	}

	public boolean add(String playerName) {
		players.add(new Player(playerName));

		System.out.println(playerName + " was added");
		System.out.println("They are player number " + players.size());
		return true;
	}

	public void roll(int roll) {
		System.out.println(currentPlayer() + " is the current player");
		System.out.println("They have rolled a " + roll);

		Player player = currentPlayer();
		if (player.isInPenaltyBox()) {
			isGettingOutOfPenaltyBox = roll % 2 != 0;
			if (isGettingOutOfPenaltyBox) {
				System.out.println(currentPlayer() + " is getting out of the penalty box");
			} else {
				System.out.println(currentPlayer() + " is not getting out of the penalty box");
				return;
			}
		}

		player.setPlace(player.getPlace() + roll);
		if (player.getPlace() > 12) player.setPlace(player.getPlace() - 12);

		System.out.println(currentPlayer()
				+ "'s new location is "
				+ player.getPlace());
		System.out.println("The category is " + currentCategory());
		askQuestion();
	}

	private void askQuestion() {
		System.out.println(questions.get(currentCategory()).removeFirst());
	}


	private Categories currentCategory() {
		Categories[] categories = Categories.values();
		return categories[(currentPlayer().getPlace() - 1) % 4];
	}

	public boolean handleCorrectAnswer() {
		if (currentPlayer().isInPenaltyBox() && !isGettingOutOfPenaltyBox) {
			currentPlayer++;
			if (currentPlayer == players.size()) currentPlayer = 0;
			return true;
		}

		System.out.println("Answer was correct!!!!");
		Player player = currentPlayer();
		player.setPurse(player.getPurse() + 1);
		System.out.println(currentPlayer()
				+ " now has "
				+ player.getPurse()
				+ " Gold Coins.");

		boolean winner = didPlayerWin();
		currentPlayer++;
		if (currentPlayer == players.size()) currentPlayer = 0;

		return winner;
	}

	public boolean wrongAnswer() {
		System.out.println("Question was incorrectly answered");
		Player player = currentPlayer();
		System.out.println(player + " was sent to the penalty box");
		player.setInPenaltyBox(true);

		currentPlayer++;
		if (currentPlayer == players.size()) currentPlayer = 0;
		return true;
	}


	private boolean didPlayerWin() {
		return !(currentPlayer().getPurse() == 6);
	}

	private Player currentPlayer() {
		return players.get(currentPlayer);
	}
}
