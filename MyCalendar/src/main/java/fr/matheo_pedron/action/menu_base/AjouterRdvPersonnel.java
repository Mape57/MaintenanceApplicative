package fr.matheo_pedron.action.menu_base;

import fr.matheo_pedron.action.Action;
import fr.matheo_pedron.evenement.Evenement;
import fr.matheo_pedron.evenement.builder.RdvPersonnelBuilder;

import static fr.matheo_pedron.application.Main.calendar;

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
