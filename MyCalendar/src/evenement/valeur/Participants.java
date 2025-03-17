package src.evenement.valeur;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {
	private List<Personne> participants;

	public Participants() {
		this.participants = new ArrayList<>();
	}

	public void ajouterParticipant(Personne personne) {
		participants.add(personne);
	}

	@Override
	public String toString() {
		return participants.stream().map(Personne::getNom).collect(Collectors.joining(", "));
	}
}
