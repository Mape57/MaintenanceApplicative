package action.menu_base;

import action.Action;
import action.ListeActions;
import action.afficher_evenement.*;
import evenement.Evenement;
import evenement.ListeEvenements;

import java.util.List;

import static application.Main.scanner;

public class Visualiser implements Action<Boolean> {
	private static final ListeActions<ListeEvenements> listeActions = new ListeActions<>(List.of(
			new AfficherTous(),
			new AfficherMois(),
			new AfficherSemaine(),
			new AfficherJour(),
			new Retour()
	));

	@Override
	public Boolean run() {
		System.out.println("\n=== Menu de visualisation d'Événements ===");
		System.out.println(listeActions);

		System.out.print("Votre choix : ");
		String choix = scanner.nextLine();
		ListeEvenements evenements = listeActions.get(Integer.parseInt(choix) - 1).run();
		if (evenements != null) afficherListe(evenements);
		return true;
	}

	@Override
	public String description() {
		return "Voir les événements";
	}

	private static void afficherListe(ListeEvenements evenements) {
		if (evenements.getAll().isEmpty()) {
			System.out.println("Aucun événement trouvé pour cette période.");
		} else {
			System.out.println("Événements trouvés : ");
			for (Evenement e : evenements.getAll()) {
				System.out.println("- " + e.description());
			}
		}
	}
}
