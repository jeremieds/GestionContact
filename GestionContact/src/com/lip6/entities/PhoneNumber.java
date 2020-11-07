package com.lip6.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class PhoneNumber implements Serializable {




	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2422495341260196920L;
	
	private String phoneKind;
	private String PhoneNumber;
	
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPhoneNumber;
	

	@ManyToOne
	@JoinColumn (name = "idContact")
	private Contact contact;

	


	public Contact getContact() {
		return contact;
	}




	public void setContact(Contact contact) {
		this.contact = contact;
	}




	public PhoneNumber( String phoneKind, String phoneNumber) {
		super();
		this.phoneKind = phoneKind;
		PhoneNumber = phoneNumber;
	}




	public PhoneNumber(){
	}







	public String getPhoneKind() {
		return phoneKind;
	}




	public void setPhoneKind(String phoneKind) {
		this.phoneKind = phoneKind;
	}




	public String getPhoneNumber() {
		return PhoneNumber;
	}




	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}




	public long getIdPhoneNumber() {
		return idPhoneNumber;
	}




	public void setIdPhoneNumber(long idPhoneNumber) {
		this.idPhoneNumber = idPhoneNumber;
	}




	@Override
	public String toString() {
		return "PhoneNumber [idContact= phoneKind=" + phoneKind + ", PhoneNumber=" + PhoneNumber
				+ ", idPhoneNumber=" + idPhoneNumber + "]";
	}
	
	
	public boolean equals(Object obj) {
        PhoneNumber pn = (PhoneNumber) obj;
        if(this.PhoneNumber.equals(pn.PhoneNumber))
            return true;

        return false;
    }
	





	
	
}
