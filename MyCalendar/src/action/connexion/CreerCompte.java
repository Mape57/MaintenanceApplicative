package action.connexion;

import action.Action;
import objet.Utilisateur;

import static application.Main.scanner;
import static action.connexion.Connexion.listeUtilisateurs;

public class CreerCompte implements Action<Utilisateur> {
	@Override
	public Utilisateur run() {
		System.out.print("Nom d'utilisateur: ");
		String nomUtilisateur = scanner.nextLine();

		System.out.print("Mot de passe: ");
		String mdpUtilisateur = scanner.nextLine();

		Utilisateur utilisateur = new Utilisateur(nomUtilisateur, mdpUtilisateur);

		System.out.print("Répéter mot de passe: ");
		if (!scanner.nextLine().equals(mdpUtilisateur)) {
			System.out.println("Les mots de passes ne correspondent pas...");
			return null;
		}

		listeUtilisateurs.ajouterUtilisateur(utilisateur);
		return utilisateur;
	}

	@Override
	public String description() {
		return "Créer un compte";
	}
}
