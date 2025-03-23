package evenement.builder;

import evenement.Reunion;
import objet.Lieu;
import objet.Participants;
import objet.Personne;

import static application.Main.scanner;
import static application.Main.utilisateur;

public class ReunionBuilder extends EvenementBuilder<ReunionBuilder> {
	private Participants participants;
	private Lieu lieu;

	private ReunionBuilder demanderParticipants() {
		participants = new Participants();
		participants.ajouterParticipant(new Personne(utilisateur.nom()));

		System.out.print("Ajouter un participant (oui / non) : ");
		while (scanner.nextLine().equals("oui")) {
			System.out.print("Participants : " + participants + ", ");
			String participant = scanner.nextLine();
			participants.ajouterParticipant(new Personne(participant));

			System.out.print("Ajouter un participant (oui / non) : ");
		}
		return this;
	}

	private ReunionBuilder demanderLieu() {
		System.out.print("Lieu : ");
		lieu = new Lieu(scanner.nextLine());
		return this;
	}

	@Override
	public Reunion build() {
		this.setProprietaire(utilisateur.nom())
				.demanderTitre()
				.demanderPeriode()
				.demanderLieu()
				.demanderParticipants();
		return new Reunion(titre, proprietaire, periode, lieu, participants);
	}

	@Override
	public ReunionBuilder getThis() {
		return this;
	}
}
