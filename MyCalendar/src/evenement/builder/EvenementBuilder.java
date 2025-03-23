package evenement.builder;

import evenement.Evenement;
import objet.Periode;
import objet.Personne;
import objet.Titre;

import java.time.LocalDateTime;

import static application.Main.scanner;

public abstract class EvenementBuilder<T extends EvenementBuilder<T>> {
	protected Titre titre;
	protected Periode periode;
	protected Personne proprietaire;

	protected T demanderTitre() {
		System.out.print("Titre de l'événement : ");
		titre = new Titre(scanner.nextLine());
		return getThis();
	}

	protected T demanderPeriode() {
		System.out.print("Année (AAAA) : ");
		int annee = Integer.parseInt(scanner.nextLine());
		System.out.print("Mois (1-12) : ");
		int mois = Integer.parseInt(scanner.nextLine());
		System.out.print("Jour (1-31) : ");
		int jour = Integer.parseInt(scanner.nextLine());
		System.out.print("Heure début (0-23) : ");
		int heure = Integer.parseInt(scanner.nextLine());
		System.out.print("Minute début (0-59) : ");
		int minute = Integer.parseInt(scanner.nextLine());
		LocalDateTime dateDebut = LocalDateTime.of(annee, mois, jour, heure, minute);

		System.out.print("Durée (en minutes) : ");
		periode = new Periode(dateDebut, Integer.parseInt(scanner.nextLine()));

		return getThis();
	}

	protected T setProprietaire(String proprietaire) {
		this.proprietaire = new Personne(proprietaire);
		return getThis();
	}

	abstract Evenement build();

	protected abstract T getThis();
}
