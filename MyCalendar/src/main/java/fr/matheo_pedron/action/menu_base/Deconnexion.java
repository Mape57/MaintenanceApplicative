package fr.matheo_pedron.action.menu_base;

import fr.matheo_pedron.action.Action;

import static fr.matheo_pedron.application.Main.scanner;

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
