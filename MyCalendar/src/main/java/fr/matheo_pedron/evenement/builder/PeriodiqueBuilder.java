package fr.matheo_pedron.evenement.builder;

import fr.matheo_pedron.evenement.Periodique;
import fr.matheo_pedron.objet.Frequence;

import static fr.matheo_pedron.application.Main.scanner;
import static fr.matheo_pedron.application.Main.utilisateur;

public class PeriodiqueBuilder extends EvenementBuilder<PeriodiqueBuilder> {
	private Frequence frequence;

	private PeriodiqueBuilder demanderFrequence() {
		System.out.print("Frequence (en jours) : ");
		frequence = new Frequence(Integer.parseInt(scanner.nextLine()));
		return this;
	}

	@Override
	public Periodique build() {
		this.setProprietaire(utilisateur.nom())
				.demanderTitre()
				.demanderPeriode()
				.demanderFrequence();
		return new Periodique(titre, proprietaire, periode, frequence);
	}

	@Override
	public PeriodiqueBuilder getThis() {
		return this;
	}
}
