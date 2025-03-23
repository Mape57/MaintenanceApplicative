package action.afficher_evenement;

import action.Action;
import evenement.ListeEvenements;

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
