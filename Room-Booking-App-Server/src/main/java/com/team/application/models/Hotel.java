package com.team.application.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "hotel")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Hotel {
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hc_name", nullable = false)
	private HotelChain hotelChain;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer hotel_id;
	
	@OneToMany(mappedBy="hotel",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Room> rooms = new ArrayList<>();
	
	@OneToMany(mappedBy="hotel",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Employee> employees = new ArrayList<>();
	
	private String street_name;
    private Integer street_number;
    private String city ;
    private String state ;
    private String country ;
    private Integer rating ;
    private String phone_number ;
    private Integer number_of_rooms = new Integer(0) ;

	
    public HotelChain getHotelChain() {
		return hotelChain;
	}
	public void setHotelChain(HotelChain hotelChain) {
		this.hotelChain = hotelChain;
	}
	public Integer getHotel_id() {
		return hotel_id;
	}
	public void setHotel_id(Integer hotel_id) {
		this.hotel_id = hotel_id;
	}
	public String getStreet_name() {
		return street_name;
	}
	public void setStreet_name(String street_name) {
		this.street_name = street_name;
	}
	public Integer getStreet_number() {
		return street_number;
	}
	public void setStreet_number(Integer street_number) {
		this.street_number = street_number;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public Integer getNumber_of_rooms() {
		return number_of_rooms;
	}
	public void setNumber_of_rooms(Integer number_of_rooms) {
		this.number_of_rooms = number_of_rooms;
	}

}

/*
  private static void persistEntity(EntityManagerFactory emf) throws Exception {
      System.out.prIntegerln("-- Persisting entity --");
      EntityManager em = emf.createEntityManager();

      Employee e = new Employee(1L, "Mike", "IT");

      CompositeTaskId cti = new CompositeTaskId(1L, 100L);
      Task task = new Task(cti, e);
      task.setTaskName("Coding");
      task.setDate(new Date());

      CompositeTaskId cti2 = new CompositeTaskId(1L, 200L);
      Task task2 = new Task(cti2, e);
      task2.setTaskName("Refactoring");
      task2.setDate(new Date());

      em.getTransaction().begin();
      em.persist(e);
      em.persist(task);
      em.persist(task2);
      em.getTransaction().commit();
      em.close();
  }
  */
