package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reservation")
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String flyNumber;
	private String lastname;
	private String firstname;
	private Integer age;
	
	@ManyToOne
	private Flight flight;
	
	public Reservation(Flight flight, String lastname, String firstname, Integer age) {
		super();
		this.flight = flight;
		this.lastname = lastname;
		this.firstname = firstname;
		this.age = age;
	}
	
	public Reservation() {}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getFlyNumber() {
		return flyNumber;
	}
	public void setFlyNumber(String string) {
		this.flyNumber = string;
	}

	@Override
	public String toString() {
		return String.format("%-10s | %-10s| %-10s| %-10s", 
				flyNumber ,lastname ,firstname ,age); 
	}
	
	
	
	
}
