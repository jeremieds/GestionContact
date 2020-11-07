package org.lip6.struts.servletAction;

import java.util.ArrayList;

import javax.naming.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.lip6.struts.domain.GroupDaos;

public class GroupViewAction extends Action {

	public ActionForward execute(final ActionMapping pMapping,

			ActionForm pForm, final HttpServletRequest pRequest,

			final HttpServletResponse pResponse) throws NamingException {

		// create a new Group

		final GroupDaos lDAOGroup = new GroupDaos();

		final ArrayList<String> lError = lDAOGroup.allGroupsNames();

		if (lError != null ) {

			// if no exception is raised, forward "success"
			pRequest.getSession().setAttribute("monTableau", lError);
			return pMapping.findForward("MenuGroupView");

		}

		else {

			// If any exception, return the "error" forward

			return pMapping.findForward("error");

		}

	}

}