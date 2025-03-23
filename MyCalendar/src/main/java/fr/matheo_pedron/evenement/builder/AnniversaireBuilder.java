package fr.matheo_pedron.evenement.builder;

import fr.matheo_pedron.evenement.Anniversaire;
import fr.matheo_pedron.objet.Periode;
import fr.matheo_pedron.objet.Personne;

import java.time.LocalDateTime;

import static fr.matheo_pedron.application.Main.scanner;
import static fr.matheo_pedron.application.Main.utilisateur;

public class AnniversaireBuilder extends EvenementBuilder<AnniversaireBuilder> {
	private Personne personneFetee;

	private AnniversaireBuilder demanderPersonneFette() {
		System.out.print("Personne fétée : ");
		personneFetee = new Personne(scanner.nextLine());
		return this;
	}

	@Override
	protected AnniversaireBuilder demanderPeriode() {
		System.out.print("Année (AAAA) : ");
		int annee = Integer.parseInt(scanner.nextLine());
		System.out.print("Mois (1-12) : ");
		int mois = Integer.parseInt(scanner.nextLine());
		System.out.print("Jour (1-31) : ");
		int jour = Integer.parseInt(scanner.nextLine());

		LocalDateTime dateDebut = LocalDateTime.of(annee, mois, jour, 0, 0);
		periode = new Periode(dateDebut, 24*60);

		return getThis();
	}

	@Override
	public Anniversaire build() {
		this.setProprietaire(utilisateur.nom())
				.demanderTitre()
				.demanderPeriode()
				.demanderPersonneFette();
		return new Anniversaire(titre, proprietaire, periode, personneFetee);
	}

	@Override
	public AnniversaireBuilder getThis() {
		return this;
	}
}
