package org.lip6.struts.servletAction;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.lip6.struts.actionForm.AddContactValidationForm;
import org.lip6.struts.domain.ContactDaos;

public class AddContactAction extends Action {

	public ActionForward execute(final ActionMapping pMapping,

			ActionForm pForm, final HttpServletRequest pRequest,

			final HttpServletResponse pResponse) throws NamingException {

		final AddContactValidationForm lForm = (AddContactValidationForm) pForm;
		final String prenom = lForm.getPrenom();
		final String nom = lForm.getNom();
		final String mail = lForm.getMail();
		final String street = lForm.getStreet();
		final String city = lForm.getCity();
		final String zip = lForm.getZip();
		final String country = lForm.getCountry();
		final String type_number = lForm.getType_number();
		final String number = lForm.getNumber();
		

		// create a new Contact

		final ContactDaos lDAOContact = new ContactDaos();

		final String lError = lDAOContact.createContact(prenom, nom, mail, street, city, zip, country, type_number,
				number);

		if (lError == null) {

			// if no exception is raised, forward "success"
			HttpSession session = pRequest.getSession();
	        session.setAttribute("nom", nom);
	        session.setAttribute("prenom", prenom);
	        session.setAttribute("action", "add");

	        
	        

			return pMapping.findForward("success");

		}

		else {

			// If any exception, return the "error" forward

			return pMapping.findForward("error");

		}

	}

}