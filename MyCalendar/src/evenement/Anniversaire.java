package evenement;

import objet.Periode;
import objet.Personne;
import objet.Titre;

// TODO implementer la logique
public class Anniversaire extends Evenement {

	public Anniversaire(Titre titre, Personne proprietaire, Periode periode) {
		super(titre, proprietaire, periode);
	}

	@Override
	public String description() {
		return "";
	}
}
