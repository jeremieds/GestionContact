package com.lip6.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity 
public class Groups implements Serializable {


	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 487275485213357112L;
	
	@Column(name = "group_Name", nullable = false)
	private String groupName;
	

	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idGroup;
	
	
	@ManyToMany(mappedBy = "contactGroups")
	private Set <Contact> contacts = new HashSet <Contact>();
	
	
	
 
	public void addContact(Contact c) {
		this.contacts.add(c);
	}
	
	public void removeContact(Contact c) {
		this.contacts.remove(c);
	}


	public Set<Contact> getContacts() {
		return contacts;
	}



	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}



	public Groups(){
	}
	
	
	
	public Groups(String groupName) {
		super();
		this.groupName = groupName;
	}

	


	public long getIdGroup() {
		return idGroup;
	}



	public String getGroupName() {
		return groupName;
	}


	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Override
	public String toString() {
		return "Group [groupName=" + groupName + ", idGroup=" + idGroup + "]";
	}

	
	
}
