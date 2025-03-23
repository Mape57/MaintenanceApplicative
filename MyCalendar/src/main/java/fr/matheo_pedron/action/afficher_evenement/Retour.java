package fr.matheo_pedron.action.afficher_evenement;

import fr.matheo_pedron.action.Action;
import fr.matheo_pedron.evenement.ListeEvenements;

public class Retour implements Action<ListeEvenements> {
	@Override
	public ListeEvenements run() {
		return null;
	}

	@Override
	public String description() {
		return "Retour";
	}
}
