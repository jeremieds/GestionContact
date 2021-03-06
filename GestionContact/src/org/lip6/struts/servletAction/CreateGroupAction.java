package org.lip6.struts.servletAction;

import javax.naming.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.lip6.struts.actionForm.CreateGroupValidationForm;
import org.lip6.struts.domain.GroupDaos;

public class CreateGroupAction extends Action {

	public ActionForward execute(final ActionMapping pMapping,

			ActionForm pForm, final HttpServletRequest pRequest,

			final HttpServletResponse pResponse) throws NamingException {

		final CreateGroupValidationForm lForm = (CreateGroupValidationForm) pForm;
		final String groupName = lForm.getGroupName();
		 

		// create a new Contact

		final GroupDaos lDAOGroup = new GroupDaos();

		final String lError = lDAOGroup.createGroup(groupName);

		if (lError == null) {

			// if no exception is raised, forward "success"
			HttpSession session = pRequest.getSession();
			session.setAttribute("action", "createGroup");
			return pMapping.findForward("success");

		}

		else {

			// If any exception, return the "error" forward

			return pMapping.findForward("error");

		}

	}

}