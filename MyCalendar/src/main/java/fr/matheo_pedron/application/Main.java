package fr.matheo_pedron.application;

import fr.matheo_pedron.action.connexion.Connexion;
import fr.matheo_pedron.action.menu_base.MenuBase;
import fr.matheo_pedron.objet.Utilisateur;

import java.util.Scanner;

public class Main {
	public static final Scanner scanner = new Scanner(System.in);
	public static final CalendarManager calendar = new CalendarManager();
	public static Utilisateur utilisateur = new Utilisateur("", "");

	private static final String TITLE = """
			  _____         _                   _                __  __
			 / ____|       | |                 | |              |  \\/  |
			| |       __ _ | |  ___  _ __    __| |  __ _  _ __  | \\  / |  __ _  _ __    __ _   __ _   ___  _ __
			| |      / _` || | / _ \\| '_ \\  / _` | / _` || '__| | |\\/| | / _` || '_ \\  / _` | / _` | / _ \\| '__|
			| |____ | (_| || ||  __/| | | || (_| || (_| || |    | |  | || (_| || | | || (_| || (_| ||  __/| |
			 \\_____| \\__,_||_| \\___||_| |_| \\__,_| \\__,_||_|    |_|  |_| \\__,_||_| |_| \\__,_| \\__, | \\___||_|
			                                                                                   __/ |
			                                                                                  |___/""";

	public static void main(String[] args) {
		System.out.println(TITLE);

		while (true) {
			while ((utilisateur = Connexion.run()) == null) ;
			while (MenuBase.run()) ;
		}
	}


}
