package org.lip6.struts.actionForm;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class LoginValidationForm extends org.apache.struts.action.ActionForm {

	private static final long serialVersionUID = 1L;
	private String login = null;
	private String password = null;

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String string) {
		this.login = string;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {

		this.login = null;
		this.password = null;
	}

	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();

		if (getLogin() == null || getLogin().length() < 1) {
			errors.add("login", new ActionMessage("login.lg.error.required"));
		}
		
		if (getPassword() == null || getPassword().length() < 1) {
			errors.add("login", new ActionMessage("password.lg.error.required"));
		}
		
		return errors;
	}

}
