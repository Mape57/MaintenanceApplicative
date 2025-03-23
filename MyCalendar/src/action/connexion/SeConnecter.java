package action.connexion;

import action.Action;
import objet.Utilisateur;

import static application.Main.scanner;
import static action.connexion.Connexion.listeUtilisateurs;

public class SeConnecter implements Action<Utilisateur> {
	@Override
	public Utilisateur run() {
		System.out.print("Nom d'utilisateur: ");
		String nomUtilisateur = scanner.nextLine();

		System.out.print("Mot de passe: ");
		String mdpUtilisateur = scanner.nextLine();

		Utilisateur utilisateur = new Utilisateur(nomUtilisateur, mdpUtilisateur);
		if (!listeUtilisateurs.contains(utilisateur)) {
			utilisateur = null;
			System.out.println("Utilisateur inconnu...\n");
		}

		return utilisateur;
	}

	@Override
	public String description() {
		return "Se connecter";
	}
}
