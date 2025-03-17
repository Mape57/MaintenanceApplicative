package src.evenement;

import src.evenement.valeur.*;

public class Reunion extends Evenement {
	private Lieu lieu;
	private Participants participants;

	public Reunion(Titre title, Personne proprietaire, Periode periode, Lieu lieu, Participants participants) {
		super(title, proprietaire, periode);
		this.lieu = lieu;
		this.participants = participants;
	}

	@Override
	public String description() {
		return "Réunion : " + titre.getTitre() + " à " + lieu.getLieu() + " avec " + participants.toString();
	}
}
