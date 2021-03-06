package org.lip6.struts.servletAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.lip6.struts.actionForm.LoginValidationForm;
import org.lip6.struts.domain.ContactDaos;

public class LoginAction extends Action {

	public ActionForward execute(final ActionMapping pMapping,

			ActionForm pForm, final HttpServletRequest pRequest,

			final HttpServletResponse pResponse) throws Exception {

		final LoginValidationForm lForm = (LoginValidationForm) pForm;

		final String login = lForm.getLogin();
		final String password = lForm.getPassword();

		// read a Contact

		final ContactDaos lDAOContact = new ContactDaos();

		final String lError = lDAOContact.loginCheck(login, password);

		if (lError == null) {

			// if no exception is raised, forward "success"
			
			HttpSession session = pRequest.getSession();
			session.setAttribute("login", login);
			System.out.println("test");
			return pMapping.findForward("success");
		

		}

		else {

			// If any exception, return the "error" forward

			return pMapping.findForward("error");

		}

	}

}