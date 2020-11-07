package org.lip6.struts.actionForm;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class DeleteContactGroupValidationForm extends org.apache.struts.action.ActionForm {

	private static final long serialVersionUID = 1L;
	private String mail = null;

	public String getMail() {
		return mail;
	}

	public void setMail(String string) {
		mail = string;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {

		this.mail = null;
	}

	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();

		if (getMail() == null || getMail().length() < 1) {
			errors.add("email", new ActionMessage("creation.email.error.required"));
		}

		return errors;

	}

}

