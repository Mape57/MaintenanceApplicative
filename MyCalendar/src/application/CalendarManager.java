package application;

import evenement.Evenement;
import evenement.ListeEvenements;
import objet.Periode;

public class CalendarManager {
	private ListeEvenements listeEvenements;

	public CalendarManager() {
		this.listeEvenements = new ListeEvenements();
	}

	public void ajouterEvent(Evenement evenement) {
		listeEvenements.ajouterEvenement(evenement);
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
		throw new UnsupportedOperationException("Not implemented yet");
	}

	public ListeEvenements getListeEvenements() {
		return listeEvenements;
	}
}