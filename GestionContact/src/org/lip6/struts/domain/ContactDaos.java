package org.lip6.struts.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.sql.DataSource;

import com.lip6.entities.Adress;
import com.lip6.entities.Contact;
import com.lip6.entities.Groups;
import com.lip6.entities.PhoneNumber;
import com.lip6.util.JpaUtil;

public class ContactDaos {
	public ContactDaos() {

	}


	/*
	public String createContact(String nom, String prenom, String mail, String street, String city, String zip,
			String country, String type_number, String number) throws NamingException {

		ResultSet rs = null;
		DataSource ds = null;
		Connection cn = null;
		PreparedStatement pstmt = null;

		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/ContactBD");
			cn = (Connection) ds.getConnection();

			if (!mailPresent(mail)) {

				String requete = "Insert into contact values(null,?,?,?)";
				pstmt = cn.prepareStatement(requete);
				pstmt.setString(1, prenom);
				pstmt.setString(2, nom);
				pstmt.setString(3, mail);
				pstmt.executeUpdate();
				String requete2 = "select id_contact from contact where mail= ?";
				pstmt = cn.prepareStatement(requete2);
				pstmt.setString(1, mail);
				rs = pstmt.executeQuery();
				rs.first();
				String id_contact = rs.getString("id_contact");

				String requete3 = "Insert into phone_number values(null,?,?,?)";
				pstmt = cn.prepareStatement(requete3);
				pstmt.setString(1, id_contact);
				pstmt.setString(2, type_number);
				pstmt.setString(3, number);
				pstmt.executeUpdate();

				String requete4 = "Insert into adress values(?,?,?,?,?)";
				pstmt = cn.prepareStatement(requete4);
				pstmt.setString(1, id_contact);
				pstmt.setString(2, street);
				pstmt.setString(3, city);
				pstmt.setString(4, zip);
				pstmt.setString(5, country);
				pstmt.executeUpdate();

				System.out.println("Insertion de " + nom + " " + prenom + " " + mail);
				System.out.println("numero " + number + " bien enregistr�");
				System.out.println("rue " + street + "ville" + city + " code postal " + zip + " pays" + country
						+ " bien enregistr�");

			} else {
				System.out.println("le mail " + mail + " est deja present");
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

	}
	 */


	public String createContact(String nom, String prenom, String mail, String street, String city, String zip,
			String country, String type_number, String number) throws NamingException {


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
			Contact contact = new Contact(prenom,nom, mail);
			Adress adress = new Adress(street, city, zip, country);
			PhoneNumber phoneNumber1 = new PhoneNumber(type_number, number);


			phoneNumber1.setContact(contact);


			contact.getPhones().add(phoneNumber1);

			contact.setAdress(adress);
			adress.setContact(contact);


			// 4 : Persistance Objet/Relationnel : cr�ation d'un enregistrement en base

			em.persist(contact);
			em.persist(adress);
			em.persist(phoneNumber1);


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
			return "error";

		}
		return null;

	}
	/*
	public String readContact(String mail) throws NamingException {
		ResultSet rs = null;
		String res, nom, prenom, street, city, zip, country, phone_kind, phone_number;
		DataSource ds = null;
		Connection cn = null;
		PreparedStatement pstmt = null;

		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/ContactBD");
			cn = ds.getConnection();

			if (mailPresent(mail)) {

				String requete = " select * from contact c, adress a, phone_number p where c.id_contact=a.id_adress and c.id_contact=p.id_contact and c.mail=?";
				pstmt = cn.prepareStatement(requete);
				pstmt.setString(1, mail);
				rs = pstmt.executeQuery();
				rs.first();
				nom = rs.getString("lastname");
				prenom = rs.getString("firstname");
				mail = rs.getString("mail");
				street = rs.getString("street");
				city = rs.getString("city");
				zip = rs.getString("zip");
				country = rs.getString("country");
				phone_kind = rs.getString("phone_kind");
				phone_number = rs.getString("phone_number");
				res = "<br>Main Information :  " + prenom + " " + nom + " " + mail + "<br>Adress :  " + street + " "
						+ city + " " + zip + " " + country + "<br>Phone :  " + phone_kind + " " + phone_number
						+ "<br><br>";
				return res;
			} else {
				System.out.println("le mail " + mail + " n'existe pas");
				return null;
			}

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			try {
				if (cn != null)
					cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;

	}
	 */
	public String readContact(String mail) throws NamingException {

		boolean success=false;
		String res, nom, prenom, street, city, zip, country, phone_kind, phone_number;

		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();

			// 2 : Ouverture transaction 
			EntityTransaction tx =  em.getTransaction();
			tx.begin();
			//Contact contact = (Contact) em.createQuery("SELECT c FROM Contact c where c.mail = :value").setParameter("value", mail).getSingleResult();

			Query q = em.createQuery("SELECT c FROM Contact c where c.email = '" + mail + "'",Contact.class);
			Contact contact = (Contact) q.getSingleResult();
			//Contact contact = em.find(Contact.class, mail);



			nom = contact.getLastName();
			prenom = contact.getFirstName();
			mail =  contact.getEmail();
			street =  contact.getAdress().getStreet();
			city =  contact.getAdress().getCity();
			zip = contact.getAdress().getZip();
			country = contact.getAdress().getCountry();
			phone_kind = contact.getPhones().iterator().next().getPhoneKind();
			phone_number = contact.getPhones().iterator().next().getPhoneNumber();
			res = "<br>Main Information :  " + prenom + " " + nom + " " + mail + "<br>Adress :  " + street + " "
					+ city + " " + zip + " " + country + "<br>Phone :  " + phone_kind + " " + phone_number
					+ "<br><br>";




			// 5 : Fermeture transaction 
			tx.commit();


			// 6 : Fermeture de l'EntityManager et de unit� de travail JPA 
			em.close();

			// 7: Attention important, cette action ne doit s'executer qu'une seule fois et non pas à chaque instantiation du ContactDAO
			//Donc, pense bien à ce qu'elle soit la dernière action de votre application
			//JpaUtil.close();	
			return res;

		}
		catch (Exception e) {
			e.printStackTrace();
			return "error";


		}
	}

	/*
	public String updateContact(String mail, String selection, String modif) throws NamingException {
		DataSource ds = null;
		Connection cn = null;
		PreparedStatement pstmt = null;
		int rs;
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/ContactBD");
			cn = ds.getConnection();

			if (mailPresent(mail)) {
				String requete = "Update contact set " + selection + "= ? where mail = ? ";
				pstmt = cn.prepareStatement(requete);
				// pstmt.setString(1, selection);

				pstmt.setString(1, modif);
				pstmt.setString(2, mail);
				rs = pstmt.executeUpdate();
				// rs = cn.createStatement().executeUpdate(requete);

				System.out.println("Update de la colonne " + selection + " est devenue " + modif);
			} else {
				System.out.println("le mail " + mail + " n'existe pas");
				return "error";
			}
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			try {
				if (cn != null)
					cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}*/

	public String updateContact(String mail, String selection, String modif) throws NamingException {
		boolean success=false;

		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();

			// 2 : Ouverture transaction 
			EntityTransaction tx =  em.getTransaction();
			tx.begin();
			//Contact contact = (Contact) em.createQuery("SELECT c FROM Contact c where c.mail = :value").setParameter("value", mail).getSingleResult();

			Query q = em.createQuery("SELECT c FROM Contact c where c.email = '" + mail + "'",Contact.class);
			Contact contact = (Contact) q.getSingleResult();
			Adress adress = contact.getAdress();
			//Contact contact = em.find(Contact.class, mail);
			switch(selection) {
			case "firstname":
				contact.setFirstName(modif);
				
				break;
			case "lastname":
				contact.setLastName(modif);
				break;
			case "zip":
				adress.setZip(modif);
				break;
			case "city":
				adress.setCity(modif);
				break;
			case "country":
				adress.setCountry(modif);
				break;
			case "street":
				adress.setStreet(modif);
				break;

			}
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
	

	public String deleteContact(String lastName) throws NamingException {
		
		//Avant l'utilisation de classe JpaUtil	
		//EntityManagerFactory emf=Persistence.createEntityManagerFactory("projetJPA");
		
		//1: obtenir une connexion et un EntityManager, en passant par la classe JpaUtil
		
	    boolean success=false;

		try {
	    EntityManager em=JpaUtil.getEmf().createEntityManager();

		// 2 : Ouverture transaction 
		EntityTransaction tx =  em.getTransaction();
		tx.begin();
		
		TypedQuery<Contact> query =
			  	em.createQuery("SELECT c FROM Contact c WHERE c.lastName = '"+ lastName +"'", Contact.class);
			    Contact results = query.getSingleResult();
		
		// 3 : Instanciation Objet(s) m�tier (s)
		Contact contact = em.find(Contact.class, results.getId());
		//contact.setAdress(null);
		//contact.setEmail(null);
		//contact.setPhones(null);
		//contact.setContactGroups(null);
		
		// 4 : Persistance Objet/Relationnel : cr�ation d'un enregistrement en base
		 
		//em.persist(contact);


		//ici l'objet est dans un �tat manag� par l'EM, pas besoin d'un nouveau persist
		//contact.setLastName("Blanquito");
		em.remove(contact);
		em.getTransaction().commit();
		
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

	
		/*public String deleteContact(String mail) throws NamingException {
			DataSource ds = null;
			Connection cn = null;
			PreparedStatement pstmt = null;
=======
		public String deleteContact(String lastName) throws NamingException {
			//Avant l'utilisation de classe JpaUtil	
			//EntityManagerFactory emf=Persistence.createEntityManagerFactory("projetJPA");
			
			//1: obtenir une connexion et un EntityManager, en passant par la classe JpaUtil
			
		    boolean success=false;
>>>>>>> branch 'master' of https://github.com/jeremieds/GestionContact.git

			try {
		    EntityManager em=JpaUtil.getEmf().createEntityManager();

			// 2 : Ouverture transaction 
			EntityTransaction tx =  em.getTransaction();
			tx.begin();
			
			TypedQuery<Contact> query =
				  	em.createQuery("SELECT c FROM Contact c WHERE c.lastName = '"+ lastName +"'", Contact.class);
				    Contact results = query.getSingleResult();
			
			// 3 : Instanciation Objet(s) m�tier (s)
			Contact contact = em.find(Contact.class, results.getId());
			//contact.setAdress(null);
			//contact.setEmail(null);
			//contact.setPhones(null);
			//contact.setContactGroups(null);
			
			// 4 : Persistance Objet/Relationnel : cr�ation d'un enregistrement en base
			 
			//em.persist(contact);

	
			//ici l'objet est dans un �tat manag� par l'EM, pas besoin d'un nouveau persist
			//contact.setLastName("Blanquito");
			em.remove(contact);
			em.getTransaction().commit();
			
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
		
		public String addContactGroup(String mail, String groupName) throws NamingException {
			DataSource ds = null;
			Connection cn = null;
			PreparedStatement pstmt = null;

			try {

				Context ctx = new InitialContext();
				ds = (DataSource) ctx.lookup("java:comp/env/jdbc/ContactBD");
				cn = ds.getConnection();

				if (mailPresent(mail)) {

					String requete = " insert into contact_group_int values(null,(select id_group from contact_group where group_name = ?),(select id_contact from contact where mail = ?));";
					pstmt = cn.prepareStatement(requete);
					pstmt.setString(1, groupName);
					pstmt.setString(2, mail);
					pstmt.executeUpdate();
				} else {
					System.out.println("le mail " + mail + " n'existe pas");
					return "error le mail est deja present";
				}
				return null;
			} catch (SQLException e) {
				return "SQLException : " + e.getMessage();
			} finally {
				try {
					if (cn != null)
						cn.close();
				} catch (SQLException e) {
					return "SQLException : " + e.getMessage();
				}
			}
		}
		*/
		
	public String addContactGroup(String mail, String groupName) throws NamingException {

		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();

			// 2 : Ouverture transaction 
			EntityTransaction tx =  em.getTransaction();
			tx.begin();
			
			TypedQuery<Contact> query =
				  	em.createQuery("SELECT c FROM Contact c WHERE c.email = '"+ mail +"'", Contact.class);
				    Contact contact = query.getSingleResult();
				    
			TypedQuery<Groups> query2 =
						  	em.createQuery("SELECT g FROM Groups g WHERE g.groupName = '"+ groupName +"'", Groups.class);
						    Groups groups = query2.getSingleResult();	

			
			groups.addContact(contact);
					



			// 4 : Persistance Objet/Relationnel : cr�ation d'un enregistrement en base

			em.flush();


			// 5 : Fermeture transaction 
			tx.commit();


			// 6 : Fermeture de l'EntityManager et de unit� de travail JPA 
			em.close();

			// 7: Attention important, cette action ne doit s'executer qu'une seule fois et non pas à chaque instantiation du ContactDAO
			//Donc, pense bien à ce qu'elle soit la dernière action de votre application
			//JpaUtil.close();	
			return null;
		}
		catch (Exception e) {
			e.printStackTrace();
			return "error";

		}
}

		public String deleteContactGroup(String mail, String groupName) throws NamingException {
			DataSource ds = null;
			Connection cn = null;
			PreparedStatement pstmt = null;

			try {

				Context ctx = new InitialContext();
				ds = (DataSource) ctx.lookup("java:comp/env/jdbc/ContactBD");
				cn = ds.getConnection();

				if (mailPresent(mail)) {

					String requete = " delete from contact_group_int where id_group = (select id_group from contact_group where group_name = ?) and id_contact = (select id_contact from contact where mail = ?);";
					pstmt = cn.prepareStatement(requete);
					pstmt.setString(1, groupName);
					pstmt.setString(2, mail);
					pstmt.executeUpdate();
				} else {
					System.out.println("le mail " + mail + " n'existe pas");
					return "error le mail est deja present";
				}
				return null;
			} catch (SQLException e) {
				return "SQLException : " + e.getMessage();
			} finally {
				try {
					if (cn != null)
						cn.close();
				} catch (SQLException e) {
					return "SQLException : " + e.getMessage();
				}
			}
		}

		public String loginCheck(String mail, String password) {
			if (mail.equals(password)) {
				return null;
			} else {
				return "error mail et password ne correspondent pas";
			}
		}

		public boolean mailPresent(String mail) throws NamingException, SQLException {

			ResultSet rs = null;
			DataSource ds = null;
			Connection cn = null;
			PreparedStatement pstmt = null;

			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/ContactBD");
			cn = (Connection) ds.getConnection();

			String requeteVerif = "select mail from contact where mail = ? ";
			pstmt = cn.prepareStatement(requeteVerif);
			pstmt.setString(1, mail);
			rs = pstmt.executeQuery();
			if (rs.first()) {
				return true;
			} else {
				return false;
			}

		}
	}