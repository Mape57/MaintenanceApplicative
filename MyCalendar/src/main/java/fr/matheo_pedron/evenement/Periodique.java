package fr.matheo_pedron.evenement;

import fr.matheo_pedron.objet.Frequence;
import fr.matheo_pedron.objet.Periode;
import fr.matheo_pedron.objet.Personne;
import fr.matheo_pedron.objet.Titre;

import java.time.LocalDateTime;

public class Periodique extends Evenement {
	private Frequence frequence;

	public Periodique(Titre titre, Personne proprietaire, Periode periode, Frequence frequence) {
		super(titre, proprietaire, periode);
		this.frequence = frequence;
	}

	@Override
	public String description() {
		return "Événement périodique : " + titre + " tous les " + frequence + " jours";
	}

	@Override
	public boolean evenementDansPeriode(Periode periode) {
		LocalDateTime temp = this.periode.dateDebut();
		while (temp.isBefore(periode.dateFin())) {
			if (!temp.isBefore(periode.dateDebut())) {
				return true;
			}
			temp = temp.plusDays(this.getFrequence());
		}
		return false;
	}

	@Override
	public boolean conflit(Evenement e) {
		LocalDateTime this_debut = this.periode.dateDebut();
		while (this_debut.isBefore(e.periode.dateFin())) {
			if (!this_debut.isBefore(e.periode.dateDebut())) {
				return true;
			}
			this_debut = this_debut.plusDays(this.getFrequence());
		}
		return false;
	}

	public int getFrequence() {
		return frequence.frequence();
	}
}
