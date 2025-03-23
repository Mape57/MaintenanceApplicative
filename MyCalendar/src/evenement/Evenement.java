package evenement;

import objet.EventId;
import objet.Periode;
import objet.Personne;
import objet.Titre;

import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Evenement {
	protected EventId eventId = new EventId();
	protected Titre titre;
	protected Personne proprietaire;
	protected Periode periode;

	public Evenement(Titre titre, Personne proprietaire, Periode periode) {
		this.titre = titre;
		this.proprietaire = proprietaire;
		this.periode = periode;
	}

	public abstract String description();

	public boolean evenementDansPeriode(Periode periode) {
		LocalDateTime this_debut = this.periode.dateDebut();
		LocalDateTime other_debut = periode.dateDebut();
		LocalDateTime other_fin = periode.dateFin();

		return !this_debut.isBefore(other_debut) && !this_debut.isAfter(other_fin);
	}

	public boolean conflit(Evenement e) {
		return this.periode.dateDebut().isBefore(e.periode.dateFin()) && this.periode.dateFin().isAfter(e.periode.dateDebut());
	}

	public Periode getPeriode() {
		return periode;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Evenement evenement)) return false;
		return Objects.equals(eventId, evenement.eventId);
	}
}