package fr.matheo_pedron.action.afficher_evenement;

import fr.matheo_pedron.action.Action;
import fr.matheo_pedron.evenement.ListeEvenements;
import fr.matheo_pedron.objet.Periode;

import java.time.LocalDateTime;

import static fr.matheo_pedron.application.Main.calendar;
import static fr.matheo_pedron.application.Main.scanner;

public class AfficherJour implements Action<ListeEvenements> {
	@Override
	public ListeEvenements run() {
		System.out.print("Entrez l'année (AAAA) : ");
		int anneeJour = Integer.parseInt(scanner.nextLine());
		System.out.print("Entrez le mois (1-12) : ");
		int moisJour = Integer.parseInt(scanner.nextLine());
		System.out.print("Entrez le jour (1-31) : ");
		int jour = Integer.parseInt(scanner.nextLine());

		LocalDateTime debutJour = LocalDateTime.of(anneeJour, moisJour, jour, 0, 0);
		LocalDateTime finJour = debutJour.plusDays(1).minusSeconds(1);

		return calendar.eventsDansPeriode(new Periode(debutJour, finJour));
	}

	@Override
	public String description() {
		return "Afficher les événements d'un JOUR précis";
	}
}
