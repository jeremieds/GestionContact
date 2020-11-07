package org.lip6.struts.actionForm;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class AddContactValidationForm extends org.apache.struts.action.ActionForm {

	private static final long serialVersionUID = 1L;
	private String prenom = null;
	private String nom = null;
	private String mail = null;
	private String street = null;
	private String city = null;
	private String zip = null;
	private String country = null;

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

	private String type_number = null;
	private String number = null;

	public String getMail() {
		return mail;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setMail(String string) {
		mail = string;
	}

	public void setPrenom(String string) {
		prenom = string;
	}

	public void setNom(String string) {
		nom = string;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.prenom = null;
		this.nom = null;
		this.mail = null;
	}

	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		if (getPrenom() == null || getPrenom().length() < 1) {
			errors.add("prenom", new ActionMessage("creation.fn.error.required"));
		}
		if (getNom() == null || getNom().length() < 1) {
			errors.add("nom", new ActionMessage("creation.ln.error.required"));
		}
		if (getMail() == null || getMail().length() < 1) {
			errors.add("mail", new ActionMessage("creation.email.error.required"));
		}

		return errors;

	}

}