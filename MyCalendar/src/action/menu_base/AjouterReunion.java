package action.menu_base;

import action.Action;
import evenement.Evenement;
import evenement.builder.ReunionBuilder;

import static application.Main.calendar;

public class AjouterReunion implements Action<Boolean> {
	@Override
	public Boolean run() {
		Evenement evenement = new ReunionBuilder().build();

		calendar.ajouterEvent(evenement);
		System.out.println("Événement ajouté.");
		return true;
	}

	@Override
	public String description() {
		return "Ajouter une réunion";
	}
}
