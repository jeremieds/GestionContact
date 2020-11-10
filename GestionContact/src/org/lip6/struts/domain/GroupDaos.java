package org.lip6.struts.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.sql.DataSource;

import org.apache.catalina.Session;

import com.lip6.entities.Adress;
import com.lip6.entities.Contact;
import com.lip6.entities.Groups;
import com.lip6.util.JpaUtil;

public class GroupDaos {
	public GroupDaos() {

	}
	
	public String createGroup(String groupName) throws NamingException {
		//Avant l'utilisation de classe JpaUtil	
		//EntityManagerFactory emf=Persistence.createEntityManagerFactory("projetJPA");
		
		//1: obtenir une connexion et un EntityManager, en passant par la classe JpaUtil
		
	    boolean success=false;

		try {
	    EntityManager em=JpaUtil.getEmf().createEntityManager();

		// 2 : Ouverture transaction 
		EntityTransaction tx =  em.getTransaction();
		tx.begin();
		
		// 3 : Instanciation Objet(s) m�tier (s)
		Groups groups = new Groups(groupName);
		
		// 4 : Persistance Objet/Relationnel : cr�ation d'un enregistrement en base
		 
		em.persist(groups);
		
		// 5 : Fermeture transaction 
		tx.commit();
		 
		// 6 : Fermeture de l'EntityManager et de unit� de travail JPA 
		em.close();
		
		// 7: Attention important, cette action ne doit s'executer qu'une seule fois et non pas à chaque instantiation du ContactDAO
		//Donc, pense bien à ce qu'elle soit la dernière action de votre application
		//JpaUtil.close();	
		
		success=true;
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
		return null;
	}

	/*public String createGroup(String groupName) throws NamingException {

		DataSource ds = null;
		Connection cn = null;
		PreparedStatement pstmt = null;

		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/ContactBD");
			cn = (Connection) ds.getConnection();

			if (!groupNamePresent(groupName)) {

				String requete = "Insert into contact_group values(null,?)";
				pstmt = cn.prepareStatement(requete);
				pstmt.setString(1, groupName);
				pstmt.executeUpdate();

				System.out.println("Cr�ation du groupe " + groupName);

			} else {
				System.out.println("Le groupe " + groupName + " est deja present");
				return "error";
			}

			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return "SQLException : " + e.getMessage();
		} finally {
			try {
				if (cn != null)
					cn.close();
			} catch (SQLException e) {
				return "SQLException : " + e.getMessage();
			}
		}

	}*/
	
	public String deleteGroup(String groupName) throws NamingException {

		//Avant l'utilisation de classe JpaUtil	
		//EntityManagerFactory emf=Persistence.createEntityManagerFactory("projetJPA");
		
		//1: obtenir une connexion et un EntityManager, en passant par la classe JpaUtil
		
	    boolean success=false;

		try {
	    EntityManager em=JpaUtil.getEmf().createEntityManager();

		// 2 : Ouverture transaction 
		EntityTransaction tx =  em.getTransaction();
		tx.begin();
		
		TypedQuery<Groups> query =
			  	em.createQuery("SELECT g FROM Groups g WHERE g.groupName = '"+ groupName +"'", Groups.class);
			    Groups results = query.getSingleResult();
		
		// 3 : Instanciation Objet(s) m�tier (s)
		Groups group = em.find(Groups.class, results.getIdGroup());
	
		//contact.setAdress(null);
		//contact.setEmail(null);
		//contact.setPhones(null);
		//contact.setContactGroups(null);
		
		// 4 : Persistance Objet/Relationnel : cr�ation d'un enregistrement en base
		 
		//em.persist(contact);


		//ici l'objet est dans un �tat manag� par l'EM, pas besoin d'un nouveau persist
		//contact.setLastName("Blanquito");
		em.remove(group);
		
		// 5 : Fermeture transaction 
		tx.commit();
		
		//ici l'objet est dans un �tat d�tach� de l'EM, la modif ne sera pas commit�e
		//contact.setLastName("Blanchard");
		 
		// 6 : Fermeture de l'EntityManager et de unit� de travail JPA 
		em.close();
		
		// 7: Attention important, cette action ne doit s'executer qu'une seule fois et non pas à chaque instantiation du ContactDAO
		//Donc, pense bien à ce qu'elle soit la dernière action de votre application
		//JpaUtil.close();	
		
		success=true;
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
		return null;
	}
	/*
	public String updateGroup(String groupName, String newGroupName) throws NamingException {

		DataSource ds = null;
		Connection cn = null;
		PreparedStatement pstmt = null;

		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/ContactBD");
			cn = (Connection) ds.getConnection();

			if (groupNamePresent(groupName)) {

				String requete = "update contact_group set group_name = ? where group_name = ?";
				pstmt = cn.prepareStatement(requete);
				pstmt.setString(1, newGroupName);
				pstmt.setString(2, groupName);
				pstmt.executeUpdate();

				System.out.println("Le groupe " + groupName + " a �t� renomm� en " + newGroupName);

			} else {
				System.out.println("Le groupe " + groupName + " n'existe pas");
				return "error";
			}

			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return "SQLException : " + e.getMessage();
		} finally {
			try {
				if (cn != null)
					cn.close();
			} catch (SQLException e) {
				return "SQLException : " + e.getMessage();
			}
		}

	}*/

	public String updateGroup(String groupName, String newGroupName) throws NamingException {


	try {
		EntityManager em=JpaUtil.getEmf().createEntityManager();

		// 2 : Ouverture transaction 
		EntityTransaction tx =  em.getTransaction();
		tx.begin();
		//Contact contact = (Contact) em.createQuery("SELECT c FROM Contact c where c.mail = :value").setParameter("value", mail).getSingleResult();

		TypedQuery<Groups> query =
			  	em.createQuery("SELECT g FROM Groups g WHERE g.groupName = '"+ groupName +"'", Groups.class);
			    Groups results = query.getSingleResult();	
		//Contact contact = em.find(Contact.class, mail);
		
		results.setGroupName(newGroupName);
		
		em.flush();
			


			// 5 : Fermeture transaction 
			tx.commit();


			// 6 : Fermeture de l'EntityManager et de unit� de travail JPA 
			em.close();

			// 7: Attention important, cette action ne doit s'executer qu'une seule fois et non pas à chaque instantiation du ContactDAO
			//Donc, pense bien à ce qu'elle soit la dernière action de votre application
			//JpaUtil.close();	

		}
		catch (Exception e) {
			e.printStackTrace();
			return "error";


		}
		return null;
		
	}
	/*
	public ArrayList<String> allGroupsNames() throws NamingException {
		ResultSet rs = null;
		DataSource ds = null;
		Connection cn = null;
		PreparedStatement pstmt = null;
		ArrayList<String> listeGroups = new ArrayList<String>();


		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/ContactBD");
			cn = (Connection) ds.getConnection();
			
			String requete = "Select group_name from contact_group";
			pstmt = cn.prepareStatement(requete);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				listeGroups.add(rs.getString("group_name"));
			}

			System.out.println(listeGroups);

			//return "error";
			

			return listeGroups;
		} catch (SQLException e) {
			listeGroups = null;
			System.out.println(e.getMessage());
			return listeGroups;
		} finally {
			try {
				if (cn != null)
					cn.close();
			} catch (SQLException e) {
				listeGroups = null;
				System.out.println(e.getMessage());
				return listeGroups;
			}
		}
	}
	*/
	
	public ArrayList<String> allGroupsNames() throws NamingException {
		ArrayList<String> listeGroups = new ArrayList<String>();
		List<Groups> listeGroups2 = new ArrayList<Groups>();

		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();

			// 2 : Ouverture transaction 
			EntityTransaction tx =  em.getTransaction();
			tx.begin();
			//Contact contact = (Contact) em.createQuery("SELECT c FROM Contact c where c.mail = :value").setParameter("value", mail).getSingleResult();

			TypedQuery<Groups> query =
				  	em.createQuery("SELECT g FROM Groups g", Groups.class);
					listeGroups2 = query.getResultList();
			//Contact contact = em.find(Contact.class, mail);
			
					for (Groups g : listeGroups2) {
					      System.out.println(g.getGroupName());
							listeGroups.add(g.getGroupName());
					  }
		

				// 5 : Fermeture transaction 
				tx.commit();


				// 6 : Fermeture de l'EntityManager et de unit� de travail JPA 
				em.close();

				// 7: Attention important, cette action ne doit s'executer qu'une seule fois et non pas à chaque instantiation du ContactDAO
				//Donc, pense bien à ce qu'elle soit la dernière action de votre application
				//JpaUtil.close();	
				return listeGroups;

			}
			catch (Exception e) {
				e.printStackTrace();
				return listeGroups;


			}
			
	}
	
	
	public ArrayList<String> viewContactGroup(String groupName) throws NamingException {
		ResultSet rs = null;
		DataSource ds = null;
		Connection cn = null;
		PreparedStatement pstmt = null;
		ArrayList<String> listeContacts = new ArrayList<String>();


		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/ContactBD");
			cn = (Connection) ds.getConnection();
			
			String requete = " select c.firstname, c.lastname, c.mail from contact c, contact_group cg, "
					+ "contact_group_int cgi where c.id_contact=cgi.id_contact "
					+ "and cg.id_group=cgi.id_group and cg.group_name=?";
			pstmt = cn.prepareStatement(requete);
			pstmt.setString(1, groupName);
			rs = pstmt.executeQuery();
			System.out.println(groupName);
			while(rs.next()) {
				String Contact = rs.getString("firstname") + " "+ rs.getString("lastname") +" "+ rs.getString("mail");
				listeContacts.add(Contact);
			}

			System.out.println(listeContacts);

			//return "error";
			

			return listeContacts;
		} catch (SQLException e) {
			listeContacts = null;
			System.out.println(e.getMessage());
			return listeContacts;
		} finally {
			try {
				if (cn != null)
					cn.close();
			} catch (SQLException e) {
				listeContacts = null;
				System.out.println(e.getMessage());
				return listeContacts;
			}
		}
	}

	private boolean groupNamePresent(String groupName) throws NamingException, SQLException {
		ResultSet rs = null;
		DataSource ds = null;
		Connection cn = null;
		PreparedStatement pstmt = null;

		Context ctx = new InitialContext();
		ds = (DataSource) ctx.lookup("java:comp/env/jdbc/ContactBD");
		cn = (Connection) ds.getConnection();

		String requeteVerif = "select group_name from contact_group where group_name = ? ";
		pstmt = cn.prepareStatement(requeteVerif);
		pstmt.setString(1, groupName);
		rs = pstmt.executeQuery();
		if (rs.first()) {
			return true;
		} else {
			return false;
		}
	}
}