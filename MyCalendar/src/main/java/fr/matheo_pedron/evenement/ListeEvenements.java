package fr.matheo_pedron.evenement;

import fr.matheo_pedron.objet.EventId;

import java.util.ArrayList;
import java.util.List;

public class ListeEvenements {
	List<Evenement> evenements = new ArrayList<>();

	public void ajouterEvenement(Evenement evenement) {
		evenements.add(evenement);
	}

	public boolean supprimerEvenement(EventId eventId) {
		return evenements.removeIf(e -> e.eventId.equals(eventId));
	}

	public List<Evenement> getAll() {
		return evenements;
	}
}
