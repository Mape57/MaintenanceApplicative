package action.afficher_evenement;

import action.Action;
import evenement.ListeEvenements;

import static application.Main.calendar;

public class AfficherTous implements Action<ListeEvenements> {
	@Override
	public ListeEvenements run() {
		return calendar.getListeEvenements();
	}

	@Override
	public String description() {
		return "Afficher TOUS les événements";
	}
}
