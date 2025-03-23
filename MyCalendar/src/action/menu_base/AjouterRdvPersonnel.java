package action.menu_base;

import action.Action;
import evenement.Evenement;
import evenement.builder.RdvPersonnelBuilder;

import static application.Main.calendar;

public class AjouterRdvPersonnel implements Action<Boolean> {
	@Override
	public Boolean run() {
		Evenement evenement = new RdvPersonnelBuilder().build();

		calendar.ajouterEvent(evenement);
		System.out.println("Événement ajouté.");
		return true;
	}

	@Override
	public String description() {
		return "Ajouter un rendez-vous personnel";
	}
}
