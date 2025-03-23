package fr.matheo_pedron.evenement;

import fr.matheo_pedron.objet.Periode;
import fr.matheo_pedron.objet.Personne;
import fr.matheo_pedron.objet.Titre;

public class RdvPersonnel extends Evenement {
	public RdvPersonnel(Titre title, Personne proprietaire, Periode periode) {
		super(title, proprietaire, periode);
	}

	@Override
	public String description() {
		return "RDV : " + titre + " à " + periode.dateDebut();
	}
}
