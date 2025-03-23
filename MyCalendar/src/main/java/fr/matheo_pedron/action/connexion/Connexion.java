package fr.matheo_pedron.action.connexion;

import fr.matheo_pedron.action.ListeActions;
import fr.matheo_pedron.objet.ListeUtilisateurs;
import fr.matheo_pedron.objet.Utilisateur;

import java.util.List;

import static fr.matheo_pedron.application.Main.scanner;

public class Connexion {
	static final ListeUtilisateurs listeUtilisateurs = new ListeUtilisateurs(List.of(
			new Utilisateur("test", "test")
	));
	private static final ListeActions<Utilisateur> listeActions = new ListeActions<>(List.of(
			new SeConnecter(),
			new CreerCompte()
	));

	public static Utilisateur run() {
		System.out.println(listeActions);

		System.out.print("Choix : ");
		String choix = scanner.nextLine();
		return listeActions.get(Integer.parseInt(choix) - 1).run();
	}
}
