package action.menu_base;

import action.ListeActions;

import java.util.List;

import static application.Main.scanner;
import static application.Main.utilisateur;

public class MenuBase {
	private static final ListeActions<Boolean> listeActions = new ListeActions<>(List.of(
			new Visualiser(),
			new AjouterRdvPersonnel(),
			new AjouterReunion(),
			new AjouterPeriodique(),
			new AjouterAnniversaire(),
			new SupprimerEvenement(),
			new Deconnexion()
	));

	public static Boolean run() {
		System.out.println("\nBonjour, " + utilisateur);
		System.out.println("=== Menu Gestionnaire d'Événements ===");
		System.out.println(listeActions);

		System.out.print("Votre choix : ");
		String choix = scanner.nextLine();
		return listeActions.get(Integer.parseInt(choix) - 1).run();
	}
}
