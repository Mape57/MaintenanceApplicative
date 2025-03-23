package fr.matheo_pedron.evenement;

import fr.matheo_pedron.objet.Periode;
import fr.matheo_pedron.objet.Personne;
import fr.matheo_pedron.objet.Titre;

import java.time.LocalDateTime;

public class Anniversaire extends Evenement {
	private Personne personne_fetee;

	public Anniversaire(Titre titre, Personne proprietaire, Periode periode, Personne personne_fetee) {
		super(titre, proprietaire, periode);
		this.personne_fetee = personne_fetee;
	}

	@Override
	public boolean evenementDansPeriode(Periode periode) {
		LocalDateTime temp = this.periode.dateDebut();
		while (temp.isBefore(periode.dateFin())) {
			if (!temp.isBefore(periode.dateDebut())) {
				return true;
			}
			temp = temp.plusYears(1);
		}
		return false;
	}

	@Override
	public boolean conflit(Evenement e) {
		// un anniversaire est simplement un rappel, il n'y a pas de chose à faire
		return false;
	}

	@Override
	public String description() {
		return "Anniversaire de " + personne_fetee + " le " + periode.dateDebut().toLocalDate();
	}
}
