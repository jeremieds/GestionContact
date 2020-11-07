package org.lip6.struts.servletAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.lip6.struts.actionForm.DeleteContactGroupValidationForm;
import org.lip6.struts.domain.ContactDaos;

public class DeleteContactGroupAction extends Action {

	public ActionForward execute(final ActionMapping pMapping,
			ActionForm pForm, final HttpServletRequest pRequest,
			final HttpServletResponse pResponse) throws Exception {

		final DeleteContactGroupValidationForm lForm = (DeleteContactGroupValidationForm) pForm;
		final String mail = lForm.getMail();
		final ContactDaos lDAOContact = new ContactDaos();
		final String groupName = (String) pRequest.getSession().getAttribute("groupe");
		final String lError = lDAOContact.deleteContactGroup(mail,groupName);

		if (lError == null) {

			// if no exception is raised, forward "success"
			HttpSession session = pRequest.getSession();
			session.setAttribute("action", "deleteContactGroup");
			return pMapping.findForward("success");

		}

		else {

			// If any exception, return the "error" forward

			return pMapping.findForward("error");

		}

	}

}
