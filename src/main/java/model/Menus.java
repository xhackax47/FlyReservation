package model;

public class Menus {
	
	public static void afficheMenuGeneral() {
		System.out.println("Bonjour et bienvenue dans le système Fly Reservation");
		System.out.println("");
		System.out.println("Menu Fly Reservation");
		System.out.println("-------------------------\n");
		System.out.println("1 - Gestion des vols");
		System.out.println("2 - Gestion des réservations");
		System.out.println("3 - Quit");
		System.out.println("");
		System.out.print("Entrez votre choix (1,2 ou 3): ");
	}
	
	public static void afficheMenuVols() {
		System.out.println("");
		System.out.println("Gestion des vols");
		System.out.println("-------------------------\n");
		System.out.println("1 - Création d'un vol");
		System.out.println("2 - Liste des vols");
		System.out.println("3 - Rechercher avion par numéro de vol");
		System.out.println("4 - Rechercher avion par ville départ et arrivée");
		System.out.println("5 - Quitter et revenir au menu général");
		System.out.println("");
		System.out.print("Entrez votre choix (1,2,3,4 ou 5): ");
	}
	
	public static void afficheMenuReservations() {
		System.out.println("");
		System.out.println("Gestion des reservations");
		System.out.println("-------------------------\n");
		System.out.println("1 - Création d'une reservation");
		System.out.println("2 - Liste des reservations par vol");
		System.out.println("3 - Annuler une reservation");
		System.out.println("4 - Afficher toutes les reservations d'une personne");
		System.out.println("5 - Quitter et revenir au menu général");
		System.out.println("");
		System.out.print("Entrez votre choix (1,2,3,4 ou 5): ");
	}

}
