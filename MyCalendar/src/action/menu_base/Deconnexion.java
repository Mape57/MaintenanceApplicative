package action.menu_base;

import action.Action;

import static application.Main.scanner;

public class Deconnexion implements Action<Boolean> {
	@Override
	public Boolean run() {
		System.out.println("Déconnexion ! Voulez-vous continuer ? (O/N)");
		return scanner.nextLine().trim().equalsIgnoreCase("oui");
	}

	@Override
	public String description() {
		return "Se déconnecter";
	}
}
