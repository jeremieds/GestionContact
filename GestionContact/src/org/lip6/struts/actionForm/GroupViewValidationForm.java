package org.lip6.struts.actionForm;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.lip6.struts.domain.Contact;

public class GroupViewValidationForm extends org.apache.struts.action.ActionForm {

	private static final long serialVersionUID = 1L;
	private String groupName = null;
	private ArrayList<Contact> listeContacts = new ArrayList<Contact>();

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public ArrayList<Contact> getListeContacts(){
		return this.listeContacts;
	}
	
	public void setListeContact(ArrayList<Contact> listeContacts) {
		this.listeContacts = listeContacts;
	}
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.groupName = null;
	}

	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		if (getGroupName() == null || getGroupName().length() < 1) {
			errors.add("GroupName", new ActionMessage("creation.gn.error.required"));
		}

		return errors;

	}

}