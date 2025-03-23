package fr.matheo_pedron.action.menu_base;

import fr.matheo_pedron.action.Action;
import fr.matheo_pedron.evenement.Anniversaire;
import fr.matheo_pedron.evenement.builder.AnniversaireBuilder;

import static fr.matheo_pedron.application.Main.calendar;

public class AjouterAnniversaire implements Action<Boolean> {
	@Override
	public Boolean run() {
		Anniversaire evenement = new AnniversaireBuilder().build();

		calendar.ajouterEvent(evenement);
		System.out.println("Événement ajouté.");
		return true;
	}

	@Override
	public String description() {
		return "Ajouter un anniversaire";
	}
}