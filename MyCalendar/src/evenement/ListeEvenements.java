package src.evenement;

import java.util.ArrayList;
import java.util.List;

public class ListeEvenements {
	List<Evenement> evenements = new ArrayList<>();

	public void ajouterEvenement(Evenement evenement) {
		evenements.add(evenement);
	}

	public List<Evenement> getAll() {
		return evenements;
	}
}
