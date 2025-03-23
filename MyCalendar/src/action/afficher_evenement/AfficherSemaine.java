package action.afficher_evenement;

import action.Action;
import evenement.ListeEvenements;
import objet.Periode;

import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.Locale;

import static application.Main.calendar;
import static application.Main.scanner;

public class AfficherSemaine implements Action<ListeEvenements> {
	@Override
	public ListeEvenements run() {
		System.out.print("Entrez l'année (AAAA) : ");
		int anneeSemaine = Integer.parseInt(scanner.nextLine());
		System.out.print("Entrez le numéro de semaine (1-52) : ");
		int semaine = Integer.parseInt(scanner.nextLine());

		LocalDateTime debutSemaine = LocalDateTime.now()
				.withYear(anneeSemaine)
				.with(WeekFields.of(Locale.FRANCE).weekOfYear(), semaine)
				.with(WeekFields.of(Locale.FRANCE).dayOfWeek(), 1)
				.withHour(0).withMinute(0);
		LocalDateTime finSemaine = debutSemaine.plusDays(7).minusSeconds(1);

		return calendar.eventsDansPeriode(new Periode(debutSemaine, finSemaine));
	}

	@Override
	public String description() {
		return "Afficher les événements d'une SEMAINE précise";
	}
}
