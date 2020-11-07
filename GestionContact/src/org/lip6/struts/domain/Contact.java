package org.lip6.struts.domain;

public class Contact {

	private long id;

	private String prenom;

	private String nom;

	private String mail;
	
	private String street;
	
	private String city;
	
	private String zip;
	
	private String country;
	
	private String type_number;
	
	private String number;
	
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

	public String getType_number() {
		return type_number;
	}

	public void setType_number(String type_number) {
		this.type_number = type_number;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * 
	 * @return Email
	 * 
	 */

	public String getMail() {
		return mail;
	}

	/**
	 * 
	 * @return First Name
	 * 
	 */

	public String getFirstName() {
		return prenom;
	}

	/**
	 * 
	 * @return Last name
	 * 
	 */
	public String getLastName() {
		return nom;
	}

	/**
	 * 
	 * @param string Sets the Email
	 * 
	 */

	public void setEmail(String string) {

		mail = string;

	}

	/**
	 * 
	 * @param string Sets the First Name
	 * 
	 */

	public void setFirstName(String string) {

		prenom = string;

	}

	/**
	 * 
	 * @param string sets the Last Name
	 * 
	 */

	public void setLastName(String string) {

		nom = string;

	}

	/**
	 * 
	 * @return ID Returns ID
	 * 
	 */

	public long getId() {

		return id;

	}

	/**
	 * 
	 * @param l Sets the ID
	 * 
	 */

	public void setId(long l) {

		id = l;

	}

}