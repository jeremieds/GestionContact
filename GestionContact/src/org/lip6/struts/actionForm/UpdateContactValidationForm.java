package org.lip6.struts.actionForm;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class UpdateContactValidationForm extends org.apache.struts.action.ActionForm {

	private static final long serialVersionUID = 1L;
	private String selection = null;
	private String modif = null;
	private String mail = null;

	public String getMail() {
		return mail;
	}

	public String getSelection() {
		return selection;
	}

	public String getModif() {
		return modif;
	}

	public void setMail(String string) {
		mail = string;
	}

	public void setSelection(String string) {
		selection = string;
	}

	public void setModif(String string) {
		modif = string;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.selection = null;
		this.modif = null;
		this.mail = null;
	}

	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		if (getSelection() == null || getSelection().length() < 1) {
			errors.add("selection", new ActionMessage("creation.sl.error.required"));
		}
		if (getModif() == null || getModif().length() < 1) {
			errors.add("modif", new ActionMessage("creation.md.error.required"));
		}
		if (getMail() == null || getMail().length() < 1) {
			errors.add("email", new ActionMessage("creation.email.error.required"));
		}

		return errors;

	}

}