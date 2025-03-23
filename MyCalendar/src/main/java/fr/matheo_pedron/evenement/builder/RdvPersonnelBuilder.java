package fr.matheo_pedron.evenement.builder;

import fr.matheo_pedron.evenement.RdvPersonnel;

import static fr.matheo_pedron.application.Main.utilisateur;

public class RdvPersonnelBuilder extends EvenementBuilder<RdvPersonnelBuilder> {
	@Override
	public RdvPersonnel build() {
		this.setProprietaire(utilisateur.nom())
				.demanderTitre()
				.demanderPeriode();
		return new RdvPersonnel(titre, proprietaire, periode);
	}

	@Override
	protected RdvPersonnelBuilder getThis() {
		return this;
	}
}
