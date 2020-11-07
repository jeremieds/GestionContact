package org.lip6.struts.actionForm;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class UpdateGroupValidationForm extends org.apache.struts.action.ActionForm {

	private static final long serialVersionUID = 1L;
	private String groupName = null;
	private String newGroupName = null;

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getNewGroupName() {
		return newGroupName;
	}

	public void setNewGroupName(String newGroupName) {
		this.newGroupName = newGroupName;
	}
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.groupName = null;
		this.newGroupName = null;
	}

	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		if (getGroupName() == null || getGroupName().length() < 1) {
			errors.add("GroupName", new ActionMessage("creation.gn.error.required"));
		}

		return errors;

	}

}