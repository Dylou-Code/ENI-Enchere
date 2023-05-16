package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.Utilisateurs;
import fr.eni.encheres.dal.UtilisateurDAO;
import fr.eni.encheres.exceptions.DALException;


public class UtilisateurDAOJdbcImpl implements UtilisateurDAO{	
	
	public List<Utilisateurs> getAllUsers() throws DALException{
		List<Utilisateurs> resultat = new ArrayList<>();
		
		try(Connection con = JdbcTools.getConnection();
			Statement stmt = con.createStatement();){
			ResultSet rs = stmt.executeQuery(SELECT_ALL);
			while(rs.next()) {
				int id = rs.getInt("no_utilisateur");
				String pseudo = rs.getString("pseudo");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String email = rs.getString("email");
				String tel = rs.getString("telephone");
				String rue = rs.getString("rue");
				String cp = rs.getString("code_postal");
				String ville = rs.getString("ville");
				String mdp = rs.getString("mot_de_passe");
				int credit = rs.getInt("credit");
				boolean admin = rs.getBoolean("administrateur");
				
				resultat.add(new Utilisateurs(id,pseudo,nom,prenom,email,tel,rue,cp,ville,mdp,credit,admin));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new DALException("Erreur à la sélection des utilisateurs", e);
		}
		
		return resultat;
	}
	
	public List<String> getPseudos() throws DALException{
		List<String> resultat = new ArrayList<>();
		
		try(Connection con = JdbcTools.getConnection();
			Statement stmt = con.createStatement();){
			ResultSet rs = stmt.executeQuery(SELECT_PSEUDOS);
			while(rs.next()) {
				String pseudo = rs.getString("pseudo");
				resultat.add(pseudo);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new DALException("Erreur à la sélection des pseudos", e);
		}
		
		return resultat;
	}

	
	public List<String> getEmails() throws DALException {
		List<String> resultat = new ArrayList<>();
		
		try(Connection con = JdbcTools.getConnection();
			Statement stmt = con.createStatement();){
			ResultSet rs = stmt.executeQuery(SELECT_EMAILS);
			while(rs.next()) {
				String email = rs.getString("email");
				resultat.add(email);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new DALException("Erreur à la sélection des emails", e);
		}
		
		return resultat;
	}
	
	
	public Utilisateurs getUserByPseudo(String pseudo) throws DALException{
		Connection con=null;
		PreparedStatement pStmt= null;
		Utilisateurs resultat = null;
		
		try {
			con = JdbcTools.getConnection();
			pStmt = con.prepareStatement(SELECT_USER_BY_PSEUDO);
			
			pStmt.setString(1, pseudo);
			
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next()) {
				int id = rs.getInt("no_utilisateur");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String email = rs.getString("email");
				String tel = rs.getString("telephone");
				String rue = rs.getString("rue");
				String cp = rs.getString("code_postal");
				String ville = rs.getString("ville");
				String mdp = rs.getString("mot_de_passe");
				int credit = rs.getInt("credit");
				boolean admin = rs.getBoolean("administrateur");
						
				resultat = new Utilisateurs(id,pseudo,nom,prenom,email,tel,rue,cp,ville,mdp,credit,admin);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Impossible de sélectionner l'utilisateur ayant le pseudo " + pseudo, e);
		}finally {
			try {
				if(pStmt!=null) {
					pStmt.close();
				}
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DALException("Impossible de sélectionner l'utilisateur ayant le pseudo " + pseudo, e);
			}
		}
		
		return resultat;
	}
	
	public Utilisateurs getUserByEmail(String email) throws DALException{
		Connection con=null;
		PreparedStatement pStmt= null;
		Utilisateurs resultat = null;
		
		try {
			con = JdbcTools.getConnection();
			pStmt = con.prepareStatement(SELECT_USER_BY_EMAIL);
			pStmt.setString(1, email);
			
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next()) {
				int id = rs.getInt("no_utilisateur");
				String pseudo = rs.getString("pseudo");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String tel = rs.getString("telephone");
				String rue = rs.getString("rue");
				String cp = rs.getString("code_postal");
				String ville = rs.getString("ville");
				String mdp = rs.getString("mot_de_passe");
				int credit = rs.getInt("credit");
				boolean admin = rs.getBoolean("administrateur");
						
				resultat = new Utilisateurs(id,pseudo,nom,prenom,email,tel,rue,cp,ville,mdp,credit,admin);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Impossible de sélectionner l'utilisateur ayant l'email " + email, e);
		}finally {
			try {
				if(pStmt!=null) {
					pStmt.close();
				}
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DALException("Impossible de sélectionner l'utilisateur ayant l'email " + email, e);
			}
		}
		
		return resultat;
	}
	
	public Utilisateurs getUserById(int id) throws DALException{
		Connection con=null;
		PreparedStatement pStmt= null;
		Utilisateurs resultat = null;
		
		try {
			con = JdbcTools.getConnection();
			pStmt = con.prepareStatement(SELECT_USER_BY_ID);
			pStmt.setInt(1, id);
			
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next()) {
				String pseudo = rs.getString("pseudo");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String email = rs.getString("email");
				String tel = rs.getString("telephone");
				String rue = rs.getString("rue");
				String cp = rs.getString("code_postal");
				String ville = rs.getString("ville");
				String mdp = rs.getString("mot_de_passe");
				int credit = rs.getInt("credit");
				boolean admin = rs.getBoolean("administrateur");
						
				resultat = new Utilisateurs(id,pseudo,nom,prenom,email,tel,rue,cp,ville,mdp,credit,admin);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Impossible de sélectionner l'utilisateur ayant l'id " + id, e);
		}finally {
			try {
				if(pStmt!=null) {
					pStmt.close();
				}
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DALException("Impossible de sélectionner l'utilisateur ayant l'id " + id, e);
			}
		}
		
		return resultat;
	}
	
	public void insertUser(Utilisateurs user) throws DALException{
		try(Connection con = JdbcTools.getConnection();
			PreparedStatement pStmt = con.prepareStatement(INSERT_USER, Statement.RETURN_GENERATED_KEYS);){
			pStmt.setString(1, user.getPseudo());
			pStmt.setString(2, user.getLastName());
			pStmt.setString(3, user.getFirstName());
			pStmt.setString(4, user.getEmail());
			pStmt.setString(5, user.getPhoneNumber());
			pStmt.setString(6, user.getStreet());
			pStmt.setString(7, user.getZipCode());
			pStmt.setString(8, user.getCity());
			pStmt.setString(9, user.getPassword());

			pStmt.executeUpdate();
		}catch(SQLException e) {
			throw new DALException("Impossible d'insérer l'utilisateur", e);
		}
	}
}
