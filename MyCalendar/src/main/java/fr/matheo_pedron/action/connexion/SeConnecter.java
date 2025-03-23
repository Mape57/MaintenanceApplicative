package fr.matheo_pedron.action.connexion;

import fr.matheo_pedron.action.Action;
import fr.matheo_pedron.objet.Utilisateur;

import static fr.matheo_pedron.action.connexion.Connexion.listeUtilisateurs;
import static fr.matheo_pedron.application.Main.scanner;

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
