package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Flight;
import model.Reservation;

public class Service {
	public static void insertReservation(Reservation r) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		em.persist(r);
		DatabaseHelper.commitTxAndClose(em);
	}

	public static void insertFly(Flight f) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		em.persist(f);
		DatabaseHelper.commitTxAndClose(em);
	}

	public static void displayFlys(List<Flight> lf) {
		String str = String.format("%-10s | %-10s | %-10s | %-10s | %-10s | %-10s", "Numéro", "Type", "Places",
				"Départ", "Arrivée", "Date");
		System.out.println(str);
		for (Flight f : lf) {
			System.out.println(f.toString());
		}
	}

	public static void listFlys() {
		List<Flight> lf = Service.findFlys();
		Service.displayFlys(lf);
	}

	public static List<Flight> findFlys() {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		TypedQuery<Flight> query = em.createQuery("SELECT f FROM Flight f ", Flight.class);
		List<Flight> lf = query.getResultList();
		DatabaseHelper.commitTxAndClose(em);
		return lf;
	}

	public static Flight findFly(String numVol) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		TypedQuery<Flight> query = em.createQuery("SELECT f FROM Flight f WHERE flightnumber =:fn ", Flight.class);
		query.setParameter("fn", numVol);
		Flight f = query.getSingleResult();
		DatabaseHelper.commitTxAndClose(em);
		return f;
	}

	public static List<Reservation> findReservations(Flight f) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		TypedQuery<Reservation> query = em.createQuery("SELECT r FROM Reservation r WHERE flight.id =:id ",
				Reservation.class);
		query.setParameter("id", f.getId());
		List<Reservation> lr = query.getResultList();
		DatabaseHelper.commitTxAndClose(em);
		return lr;
	}

	public static Reservation findReservation(String numRes) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		TypedQuery<Reservation> query = em.createQuery("SELECT r FROM Reservation r WHERE r.num =:num ",
				Reservation.class);
		query.setParameter("num", numRes);
		Reservation r = query.getSingleResult();
		DatabaseHelper.commitTxAndClose(em);
		return r;
	}

	public static void displayReservation(List<Reservation> lr) {
		for (Reservation r : lr) {
			System.out.println(r.toString());
		}

	}
}