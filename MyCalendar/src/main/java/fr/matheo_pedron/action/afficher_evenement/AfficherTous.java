package fr.matheo_pedron.action.afficher_evenement;

import fr.matheo_pedron.action.Action;
import fr.matheo_pedron.evenement.ListeEvenements;

import static fr.matheo_pedron.application.Main.calendar;

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
