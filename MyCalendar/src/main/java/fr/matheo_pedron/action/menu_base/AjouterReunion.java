package fr.matheo_pedron.action.menu_base;

import fr.matheo_pedron.action.Action;
import fr.matheo_pedron.evenement.Evenement;
import fr.matheo_pedron.evenement.builder.ReunionBuilder;

import static fr.matheo_pedron.application.Main.calendar;

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
