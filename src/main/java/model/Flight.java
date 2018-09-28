package model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import dao.Service;

@Entity
@Table(name = "flight")
public class Flight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(unique=true)
	private String flightNumber;
	private Integer nbPlace;
	
	@Enumerated(EnumType.STRING)
	private Plane avionType;
	private String departureCity;
	private String arrivalCity;
	private Date depart;
	
	@OneToMany(mappedBy="flight")
	private List<Reservation> reservation;

	public Flight(String flightNumber, Integer nbPlace, Plane avionType, String departureCity,
			String arrivalCity, Date depart) {
		super();
		this.flightNumber = flightNumber;
		this.nbPlace = nbPlace;
		this.avionType = avionType;
		this.departureCity = departureCity;
		this.arrivalCity = arrivalCity;
		this.depart = depart;
	}
	
	public Flight() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public Integer getNbPlace() {
		return nbPlace;
	}

	public void setNbPlace(Integer nbPlace) {
		this.nbPlace = nbPlace;
	}

	public Plane getAvionType() {
		return avionType;
	}

	public void setAvionType(Plane avionType) {
		this.avionType = avionType;
	}

	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public Date getDepart() {
		return depart;
	}

	public void setDepart(Date depart) {
		this.depart = depart;
	}

	public List<Reservation> getReservation() {
		return reservation;
	}

	public void setReservation(List<Reservation> reservation) {
		this.reservation = reservation;
	}

	@Override
	public String toString() {
		int n = Service.findReservations(this).size(); 
		return String.format("%-10s | %-10s| %-10s| %-10s| %-10s| %-10s", flightNumber , avionType , n+"/"+nbPlace , departureCity , arrivalCity , depart ); 
		
	}
}