package fr.matheo_pedron.action.afficher_evenement;

import fr.matheo_pedron.action.Action;
import fr.matheo_pedron.evenement.ListeEvenements;
import fr.matheo_pedron.objet.Periode;

import java.time.LocalDateTime;

import static fr.matheo_pedron.application.Main.calendar;
import static fr.matheo_pedron.application.Main.scanner;

public class AfficherPeriode  implements Action<ListeEvenements> {
	@Override
	public ListeEvenements run() {
		LocalDateTime debut = demanderDate("Entrez la date de début de la période\n");
		LocalDateTime fin = demanderDate("Entrez la date de fin de la période\n");

		return calendar.eventsDansPeriode(new Periode(debut, fin));
	}

	private LocalDateTime demanderDate(String message) {
		System.out.print(message);
		System.out.print("Entrez l'année (AAAA) : ");
		int annee = Integer.parseInt(scanner.nextLine());
		System.out.print("Entrez le mois (1-12) : ");
		int mois = Integer.parseInt(scanner.nextLine());
		System.out.print("Entrez le jour (1-31) : ");
		int jour = Integer.parseInt(scanner.nextLine());
		System.out.print("Entrez l'heure (0-23) : ");
		int heure = Integer.parseInt(scanner.nextLine());
		System.out.print("Entrez les minutes (0-59) : ");
		int minutes = Integer.parseInt(scanner.nextLine());

		return LocalDateTime.of(annee, mois, jour, heure, minutes);
	}

	@Override
	public String description() {
		return "Afficher les événements d'une période fournie";
	}
}
