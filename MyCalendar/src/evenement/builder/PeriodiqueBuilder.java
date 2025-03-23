package evenement.builder;

import evenement.Periodique;
import objet.Frequence;

import static application.Main.scanner;
import static application.Main.utilisateur;

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
