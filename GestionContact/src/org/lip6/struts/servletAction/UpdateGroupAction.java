package org.lip6.struts.servletAction;

import javax.naming.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.lip6.struts.actionForm.UpdateGroupValidationForm;
import org.lip6.struts.domain.GroupDaos;

public class UpdateGroupAction extends Action {

	public ActionForward execute(final ActionMapping pMapping,

			ActionForm pForm, final HttpServletRequest pRequest,

			final HttpServletResponse pResponse) throws NamingException {

		final UpdateGroupValidationForm lForm = (UpdateGroupValidationForm) pForm;
		final String groupName = lForm.getGroupName();
		final String newGroupName = lForm.getNewGroupName();
		 

		// create a new Group

		final GroupDaos lDAOGroup = new GroupDaos();

		final String lError = lDAOGroup.updateGroup(groupName, newGroupName);
		
		if (lError == null) {

			// if no exception is raised, forward "success"
			HttpSession session = pRequest.getSession();
			session.setAttribute("action", "updateGroup");
			return pMapping.findForward("success");

		}

		else {

			// If any exception, return the "error" forward

			return pMapping.findForward("error");

		}

	}

}