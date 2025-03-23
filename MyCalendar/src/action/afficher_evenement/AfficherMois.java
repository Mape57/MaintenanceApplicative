package action.afficher_evenement;

import action.Action;
import evenement.ListeEvenements;
import objet.Periode;

import java.time.LocalDateTime;

import static application.Main.calendar;
import static application.Main.scanner;

public class AfficherMois implements Action<ListeEvenements> {
	@Override
	public ListeEvenements run() {
		System.out.print("Entrez l'année (AAAA) : ");
		int anneeMois = Integer.parseInt(scanner.nextLine());
		System.out.print("Entrez le mois (1-12) : ");
		int mois = Integer.parseInt(scanner.nextLine());

		LocalDateTime debutMois = LocalDateTime.of(anneeMois, mois, 1, 0, 0);
		LocalDateTime finMois = debutMois.plusMonths(1).minusSeconds(1);

		return calendar.eventsDansPeriode(new Periode(debutMois, finMois));
	}

	@Override
	public String description() {
		return "Afficher les événements d'un MOIS précis";
	}
}
