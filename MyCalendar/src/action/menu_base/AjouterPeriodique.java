package action.menu_base;

import action.Action;
import evenement.Evenement;
import evenement.builder.PeriodiqueBuilder;

import static application.Main.calendar;

public class AjouterPeriodique implements Action<Boolean> {
	@Override
	public Boolean run() {
		Evenement evenement = new PeriodiqueBuilder().build();

		calendar.ajouterEvent(evenement);
		System.out.println("Événement ajouté.");
		return true;
	}

	@Override
	public String description() {
		return "Ajouter un évènement périodique";
	}
}
