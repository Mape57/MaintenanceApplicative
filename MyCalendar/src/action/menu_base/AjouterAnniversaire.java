package action.menu_base;

import action.Action;
import evenement.Evenement;
import evenement.builder.AnniversaireBuilder;

import static application.Main.calendar;

public class AjouterAnniversaire implements Action<Boolean> {
	@Override
	public Boolean run() {
		Evenement evenement = new AnniversaireBuilder().build();

		calendar.ajouterEvent(evenement);
		System.out.println("Événement ajouté.");
		return true;
	}

	@Override
	public String description() {
		return "Ajouter un anniversaire";
	}
}