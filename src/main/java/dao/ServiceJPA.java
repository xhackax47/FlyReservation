package dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import model.Flight;
import model.Plane;
import model.Reservation;

@SuppressWarnings("unused")
public class ServiceJPA {

	public static void createFly(Scanner sc) throws InterruptedException, ParseException {

		System.out.println("Création d'un vol...");
		Thread.sleep(1 * 1000);
		System.out.println("");

		System.out.println("Numéro du vol : ");
		String flightNumber = sc.nextLine();

		System.out.println("Nombres de places : ");
		Integer nbPlace = sc.nextInt();

		System.out.println("Type d'avion : ");
		String avionTypeString = sc.nextLine();

		Plane avionType = Plane.valueOf(sc.nextLine());
		System.out.println("Ville de départ");
		String departureCity = sc.nextLine();
		System.out.println("Ville d'arrivée");
		String arrivalCity = sc.nextLine();
		System.out.println("Date de départ");
		String sdate = sc.nextLine();
		Date depart = new SimpleDateFormat("dd/MM/yyyy").parse(sdate);

		System.out.println("Infos vol : " + flightNumber + " / Nombre de places : " + nbPlace + " / Type d'avion : "
				+ avionType + " / Ville de départ : " + departureCity + " / Ville d'arrivée : " + arrivalCity
				+ " / Date de départ : " + sdate);

		Flight f = new Flight(flightNumber, nbPlace, avionType, departureCity, arrivalCity, depart);
		Service.insertFly(f);

	}

	public static void createReservation(Scanner sc) throws InterruptedException, ParseException {

		System.out.println("Création d'une reservation...");
		Thread.sleep(1 * 1000);
		System.out.println("");
		System.out.println("Numéro du vol : ");
		String flightNumber = sc.nextLine();
		Flight f = Service.findFly(flightNumber);

		System.out.println("Nom : ");
		String lastname = sc.nextLine();
		System.out.println("Prénom");
		String firstname = sc.nextLine();
		System.out.println("Age");
		Integer age = Integer.parseInt(sc.nextLine());

		System.out.println("Infos reservation : " + flightNumber + " / Nom de famille : " + lastname + " / Prénom : "
				+ firstname + " / Age : " + age);

		Reservation r = new Reservation(f, lastname, firstname, age);
		Service.insertReservation(r);

		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		r = em.find(Reservation.class, r.getId());
		r.setFlyNumber(flightNumber + "-" + r.getId());
		em.merge(r);
		DatabaseHelper.commitTxAndClose(em);
	}

	public static void displayFlysByNum(Scanner sc) {
		System.out.println("Recherche de vol");
		System.out.println("Numéro de vol : ");
		String num = sc.nextLine();
		Flight f = Service.findFly(num);

		String str = String.format("%-10s | %-10s| %-10s| %-10s| %-10s| %-10s", "Numéro", "Type", "Place", "Départ",
				"Arrivée", "Date");
		System.out.println(str);
		System.out.println(f);
	}

	public static void displayResByFlyNum(Scanner sc) {
		System.out.println("Recherche de réservation");
		System.out.println("Numéro de vol : ");
		String num = sc.nextLine();
		Flight f = Service.findFly(num);
		List<Reservation> lr = Service.findReservations(f);

		String str = String.format("%-10s | %-10s| %-10s| %-10s| %-10s| %-10s", "Numéro", "Type", "Place", "Départ",
				"Arrivée", "Date");
		System.out.println(str);
		System.out.println(lr);
	}

	public static void deleteReservation(String numRes) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		Reservation r = Service.findReservation(numRes);
		em.remove(em.find(Reservation.class, r.getId()));

		DatabaseHelper.commitTxAndClose(em);
	}
}