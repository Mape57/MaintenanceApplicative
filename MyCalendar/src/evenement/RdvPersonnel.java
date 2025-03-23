package evenement;

import objet.Periode;
import objet.Personne;
import objet.Titre;

public class RdvPersonnel extends Evenement {
	public RdvPersonnel(Titre title, Personne proprietaire, Periode periode) {
		super(title, proprietaire, periode);
	}

	@Override
	public String description() {
		return "RDV : " + titre + " à " + periode.dateDebut();
	}
}
