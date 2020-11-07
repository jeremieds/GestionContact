package org.lip6.struts.domain;

public class ContactGroup {
	private long groupId;
	private String groupName;

	public ContactGroup(String groupName) {
		this.groupName = groupName;
	}

	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}
	
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

}
