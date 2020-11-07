package com.lip6.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Adress implements Serializable {




	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8167493674798776033L;
	
	private String street;
	private String city;
	private String zip;
	private String country;
	
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idAdress;
	
	@OneToOne(mappedBy="adress")
	private Contact contact;
	


	public Contact getContact() {
		return contact;
	}


	public void setContact(Contact contact) {
		this.contact = contact;
	}


	public Adress(){
	}
	
	
	public Adress(String street, String city, String zip, String country) {
		super();
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.country = country;
	}



	public String getStreet() {
		return street;
	}





	public void setStreet(String street) {
		this.street = street;
	}





	public String getCity() {
		return city;
	}





	public void setCity(String city) {
		this.city = city;
	}





	public String getZip() {
		return zip;
	}





	public void setZip(String zip) {
		this.zip = zip;
	}





	public String getCountry() {
		return country;
	}





	public void setCountry(String country) {
		this.country = country;
	}
	
	public long getIdAdress() {
		return idAdress;
	}


	public void setIdAdress(long idAdress) {
		this.idAdress = idAdress;
	}


	@Override
	public String toString() {
		return "Adress [street=" + street + ", city=" + city + ", zip=" + zip + ", country=" + country + ", idAdress="
				+ idAdress + "]";
	}
	
	





	
	
}
