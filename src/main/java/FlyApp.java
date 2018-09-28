import java.text.ParseException;
import java.util.Scanner;

import dao.Service;
import dao.ServiceJPA;

public class FlyApp {

	public static void main(String[] args) {
		
		final Scanner sc = new Scanner(System.in);
		int selection = 0;
		int flightSelection = 0;
		int reservationSelection = 0;

		do {

			System.out.println("Bonjour et bienvenue dans le système Fly Reservation");
			System.out.println("");
			System.out.println("Menu Fly Reservation");
			System.out.println("-------------------------\n");
			System.out.println("1 - Gestion des vols");
			System.out.println("2 - Gestion des réservations");
			System.out.println("3 - Quit");
			System.out.println("");
			System.out.print("Entrez votre choix (1,2 ou 3): ");
			String s=sc.nextLine();
			 selection=Integer.parseInt(s);
		//	selection = Integer.parseInt(sc.nextLine());
			
			search:
			switch (selection) {
			case 1:
				do {
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
					
					String s2=sc.nextLine();
					 flightSelection=Integer.parseInt(s2);
					//flightSelection = Integer.parseInt(sc.nextLine());
					
					switch(flightSelection) {
					case 1:
						
						try {
							ServiceJPA.createFly(sc);
						} catch (InterruptedException | ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
							
						break;
						
					case 2:
						Service.listFlys();
						break;
						
					case 3:
						ServiceJPA.displayFlysByNum(sc);
						break;
						
					case 4:
						break;
						
					case 5:			
						System.out.println("Voulez-vous retourner au menu général ? (O ou N)");
						String returnBack = sc.nextLine();
						if(returnBack == "O") {
	
							break search;
						}else {
						break;
						}
					default:
						System.out.println("Choix inconnu");
						break;
					}
				
				}while(flightSelection != 5);

				break;
			case 2:
				do {		
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
					String s3=sc.nextLine();
					reservationSelection = Integer.parseInt(s3);
//					reservationSelection = Integer.parseInt(sc.nextLine());
					
					switch(reservationSelection) {
					case 1:
						try {
							ServiceJPA.createReservation(sc);
						} catch (InterruptedException | ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case 2:
						ServiceJPA.displayResByFlyNum(sc);
						break;
					case 3:
						System.out.println("Entrer le numéro de réservation à annuler : ");
						String numRes = sc.nextLine();
						
						ServiceJPA.deleteReservation(numRes);
						System.out.println("Reservation N°" + numRes + " supprimée");
						break;
					case 4:
						break;
					case 5:
						System.out.println("Voulez-vous retourner au menu général ? (O ou N)");
						char returnBack = sc.next().charAt(0);
						if(returnBack == 'O') {
							break search;
						}
						break;
					default:
						System.out.println("Choix inconnu");
						break;
					}
				
				}while(flightSelection != 5);

				break;
			case 3:
				System.out.println("Merci d'avoir utilisé nos services et à bientôt");
				break;
			default:
				System.out.println("Choix inconnu");
			}

			
			

		} while (selection != 3);
		
		sc.close();
		System.out.flush();
		System.out.close();
	}
}