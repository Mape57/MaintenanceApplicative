package src.evenement;

import src.evenement.valeur.Personne;
import src.evenement.valeur.Periode;
import src.evenement.valeur.Titre;

public class RdvPersonnel extends Evenement {
	public RdvPersonnel(Titre title, Personne proprietaire, Periode periode) {
		super(title, proprietaire, periode);
	}

	@Override
	public String description() {
		return "RDV : " + titre + " à " + periode.getDateDebut();
	}
}
