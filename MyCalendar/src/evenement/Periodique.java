package evenement;

import objet.Frequence;
import objet.Periode;
import objet.Personne;
import objet.Titre;

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

	public int getFrequence() {
		return frequence.frequence();
	}
}
