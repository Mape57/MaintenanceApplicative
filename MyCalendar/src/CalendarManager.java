package src;

import src.evenement.Evenement;
import src.evenement.ListeEvenements;
import src.evenement.Periodique;
import src.evenement.valeur.Periode;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CalendarManager {
	public ListeEvenements listeEvenements;

	public CalendarManager() {
		this.listeEvenements = new ListeEvenements();
	}

	public void ajouterEvent(Evenement evenement) {
		listeEvenements.ajouterEvenement(evenement);
	}

	public List<Evenement> eventsDansPeriode(Periode periode) {
		List<Evenement> result = new ArrayList<>();
		for (Evenement e : listeEvenements.getAll()) {
			if (e instanceof Periodique) {
				LocalDateTime temp = e.getPeriode().getDateDebut();
				while (temp.isBefore(fin)) {
					if (!temp.isBefore(debut)) {
						result.add(e);
						break;
					}
					temp = temp.plusDays(((Periodique) e).getFrequenceJours().getFrequenceJours());
				}
			} else if (!e.getPeriode().getDateDebut().isBefore(debut) && !e.getPeriode().getDateDebut().isAfter(fin)) {
				result.add(e);
			}
		}
		return result;
	}

	public boolean conflit(Evenement e1, Evenement e2) {
		LocalDateTime fin1 = e1.getPeriode().getDateFin();
		LocalDateTime fin2 = e2.getPeriode().getDateFin();

		if (e1 instanceof Periodique || e2 instanceof Periodique) {
			return false; // Simplification abusive
		}

		if (e1.getPeriode().getDateDebut().isBefore(fin2) && fin1.isAfter(e2.getPeriode().getDateDebut())) {
			return true;
		}
		return false;
	}

	public void afficherEvenements() {
		for (Evenement e : listeEvenements.getAll()) {
			System.out.println(e.description());
		}
	}
}