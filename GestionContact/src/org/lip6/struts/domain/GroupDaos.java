package org.lip6.struts.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.*;
import javax.sql.DataSource;

import org.apache.catalina.Session;

public class GroupDaos {
	public GroupDaos() {

	}

	public String createGroup(String groupName) throws NamingException {

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

				System.out.println("Création du groupe " + groupName);

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

	}
	
	public String deleteGroup(String groupName) throws NamingException {

		DataSource ds = null;
		Connection cn = null;
		PreparedStatement pstmt = null;

		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/ContactBD");
			cn = (Connection) ds.getConnection();

			if (groupNamePresent(groupName)) {

				String requete = "delete from contact_group where group_name = ?";
				pstmt = cn.prepareStatement(requete);
				pstmt.setString(1, groupName);
				pstmt.executeUpdate();

				System.out.println("suppression du groupe " + groupName);

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
	}
	
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

				System.out.println("Le groupe " + groupName + " a été renommé en " + newGroupName);

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

	}
	
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