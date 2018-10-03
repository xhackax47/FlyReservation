package services;

import java.text.ParseException;
import java.util.Scanner;

import dao.Service;
import dao.ServiceJPA;
import model.Menus;

public class Fly {
	
	public static void start() {
		final Scanner sc = new Scanner(System.in);
		int selection = 0;
		int flightSelection = 0;
		int reservationSelection = 0;

		do {
			Menus.afficheMenuGeneral();
			String s=sc.nextLine();
			selection=Integer.parseInt(s);
			 
			search:
			switch (selection) {
			case 1:
				do {
					Menus.afficheMenuVols();
					String s2=sc.nextLine();
					flightSelection=Integer.parseInt(s2);
					
					switch(flightSelection) {
					case 1:
						
						try {
							ServiceJPA.createFly(sc);
						} catch (InterruptedException | ParseException e) {
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
					Menus.afficheMenuReservations();
					String s3=sc.nextLine();
					reservationSelection = Integer.parseInt(s3);
					
					switch(reservationSelection) {
					case 1:
						try {
							ServiceJPA.createReservation(sc);
						} catch (InterruptedException | ParseException e) {
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
