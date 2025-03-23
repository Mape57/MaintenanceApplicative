package fr.matheo_pedron.application;

import fr.matheo_pedron.evenement.Evenement;
import fr.matheo_pedron.evenement.ListeEvenements;
import fr.matheo_pedron.objet.EventId;
import fr.matheo_pedron.objet.Periode;

public class CalendarManager {
	private ListeEvenements listeEvenements;

	public CalendarManager() {
		this.listeEvenements = new ListeEvenements();
	}

	public void ajouterEvent(Evenement evenement) {
		ListeEvenements listeConflits = conflit(evenement);
		if (!listeConflits.getAll().isEmpty()) {
			System.out.println("Conflit avec les événements suivants :");
			for (Evenement e : listeConflits.getAll()) {
				System.out.println("- " + e);
			}
			return;
		}

		listeEvenements.ajouterEvenement(evenement);
	}

	public boolean supprimerEvent(EventId eventId) {
		return listeEvenements.supprimerEvenement(eventId);
	}

	public ListeEvenements eventsDansPeriode(Periode periode) {
		ListeEvenements listeEvenementsPeriode = new ListeEvenements();
		for (Evenement e : listeEvenements.getAll()) {
			if (e.evenementDansPeriode(periode)) {
				listeEvenementsPeriode.ajouterEvenement(e);
			}
		}
		return listeEvenementsPeriode;
	}

	public ListeEvenements conflit(Evenement e) {
		ListeEvenements listeConflits = new ListeEvenements();
		for (Evenement e2 : listeEvenements.getAll()) {
			if (e.conflit(e2)) {
				listeConflits.ajouterEvenement(e2);
			}
		}
		return listeConflits;
	}

	public ListeEvenements getListeEvenements() {
		return listeEvenements;
	}
}