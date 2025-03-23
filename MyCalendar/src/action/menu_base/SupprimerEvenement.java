package action.menu_base;

import action.Action;
import objet.EventId;

import static application.Main.calendar;
import static application.Main.scanner;

public class SupprimerEvenement implements Action<Boolean> {
	@Override
	public Boolean run() {
		System.out.print("Entrez l'ID de l'événement à supprimer :");
		EventId eventId = new EventId(Integer.parseInt(scanner.nextLine()));

		if (calendar.supprimerEvent(eventId))
			System.out.println("Événement supprimé.");
		else
			System.out.println("Événement non trouvé.");

		return true;
	}

	@Override
	public String description() {
		return "Supprimer un évènement";
	}
}