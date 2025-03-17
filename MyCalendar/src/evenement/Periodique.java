package src.evenement;

import src.evenement.valeur.Frequence;
import src.evenement.valeur.Personne;
import src.evenement.valeur.Periode;
import src.evenement.valeur.Titre;

public class Periodique extends Evenement {
	private Frequence frequenceJours;

	public Periodique(Titre titre, Personne proprietaire, Periode periode, Frequence frequenceJours) {
		super(titre, proprietaire, periode);
		this.frequenceJours = frequenceJours;
	}

	@Override
	public String description() {
		return "Événement périodique : " + titre + " tous les " + frequenceJours + " jours";
	}

	public Frequence getFrequenceJours() {
		return frequenceJours;
	}
}
