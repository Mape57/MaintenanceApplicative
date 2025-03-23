package evenement.builder;

import evenement.RdvPersonnel;

import static application.Main.utilisateur;

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
