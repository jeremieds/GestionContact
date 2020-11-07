package com.lip6.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Contact implements Serializable {



	/**
	 * 
	 */
	private static final long serialVersionUID = 177808013723915288L;
	
	private String firstName;
	private String lastName;
	private String email;
	
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idContact;
	
	@OneToOne(cascade=CascadeType.ALL) @JoinColumn(name="idAdress")
	private Adress adress;
	
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="contact")
	private Set <PhoneNumber> phones = new HashSet <PhoneNumber>();
	
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name = "Contact_groups",joinColumns = @JoinColumn (name = "ContactID"),
	inverseJoinColumns= @JoinColumn (name = "GroupID"))
	private Set <Groups> contactGroups = new HashSet <Groups>();
	
	
	public Set<Groups> getContactGroups() {
		return contactGroups;
	}



	public void setContactGroups(Set<Groups> contactGroups) {
		this.contactGroups = contactGroups;
	}



	public Adress getAdress() {
		return adress;
	}



	public void setAdress(Adress adress) {
		this.adress = adress;
	}



	public Set<PhoneNumber> getPhones() {
		return phones;
	}



	public void setPhones(Set<PhoneNumber> phones) {
		this.phones = phones;
	}



	public Contact(String firstName, String lastName, String email, long id) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.idContact = id;
	}
	
	
	
	public Contact(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}



	public Contact(){
	}

	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public void setFirstName(String firstname){
		this.firstName = firstname;
	}
	
	
	public String getLastName(){
		return lastName;
	}
	
	public void setLastName(String lastname){
		this.lastName = lastname;
	}
	
	public long getId(){
		return idContact;
	}
	
	public void setId(long id){
		this.idContact = id;
	}


	@Override
	public String toString() {
		return "Contact [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", id=" + idContact + "]";
	}
	
	
	
	
}
