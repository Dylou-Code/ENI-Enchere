/**
 * 
 */
package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.Utilisateurs;
import fr.eni.encheres.dal.connection.ConnectionProvider;
import fr.eni.encheres.dal.interfaces.UtilisateursDAO;
import fr.eni.encheres.exceptions.DALException;


public class UtilisateurDAOJdbcImpl implements UtilisateursDAO{	
	
	public final String SELECT_ALL = "SELECT * FROM UTILISATEURS";
	public final String SELECT_PSEUDOS = "SELECT pseudo FROM UTILISATEURS";
	public final String SELECT_EMAILS = "SELECT email FROM UTILISATEURS";
	public final String SELECT_USER_BY_PSEUDO = "SELECT * FROM UTILISATEURS WHERE pseudo=?";
	public final String SELECT_USER_BY_EMAIL = "SELECT * FROM UTILISATEURS WHERE email=?";
	public final String SELECT_USER_BY_ID = "SELECT * FROM UTILISATEURS WHERE no_utilisateur=?";
	public final String INSERT_USER = "INSERT INTO UTILISATEURS(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe) VALUES (?,?,?,?,?,?,?,?,?)";
	public final String UPDATE_USER = "UPDATE UTILISATEURS SET pseudo=?, nom=?, prenom=?, email=?, telephone=?, rue=?, code_postal=?, ville=?, mot_de_passe=? WHERE no_utilisateur=?";
	
	//toujours faire des PreparedStatement pour éviter injectionSQL
	public List<Utilisateurs> getAllUsers() throws DALException{
		List<Utilisateurs> resultat = new ArrayList<>();
		
		try(Connection con = ConnectionProvider.connection()){ 
			PreparedStatement pst = con.prepareStatement(SELECT_ALL);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Utilisateurs user = new Utilisateurs();
				user.setId(rs.getInt("no_utilisateur"));
				user.setPseudo(rs.getString("pseudo"));
				user.setLastName(rs.getString("nom"));
				user.setFirstName(rs.getString("prenom"));
				user.setPhoneNumber(rs.getString("telephone"));
				user.setEmail(rs.getString("email"));
				user.setStreet(rs.getString("rue"));
				user.setZipCode(rs.getString("code_postal"));
				user.setCity(rs.getString("ville"));
				user.setPassword(rs.getString("mot_de_passe"));
				user.setCredit(rs.getInt("credit"));
				user.setAdmin(rs.getBoolean("administrateur"));
				
				resultat.add(user);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new DALException("Erreur à la sélection des utilisateurs", e);
		}
		
		return resultat;
	}
	
	public List<String> getPseudos() throws DALException{
		List<String> resultat = new ArrayList<>();
		
		try(Connection con = ConnectionProvider.connection()){
			PreparedStatement pst = con.prepareStatement(SELECT_PSEUDOS);
			ResultSet rs = pst.executeQuery();
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
		
		try(Connection con = ConnectionProvider.connection()){ 
			PreparedStatement pst = con.prepareStatement(SELECT_EMAILS);
			ResultSet rs = pst.executeQuery();
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
		Utilisateurs resultat = null;
		
		try(Connection con = ConnectionProvider.connection()){ 
			PreparedStatement pst = con.prepareStatement(SELECT_USER_BY_PSEUDO);
			pst.setString(1, pseudo);
			ResultSet rs = pst.executeQuery();
			
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
		}
		return resultat;
	}
	
	public Utilisateurs getUserByEmail(String email) throws DALException{
		Utilisateurs resultat = null;
		
		try(Connection con = ConnectionProvider.connection()){ 
			PreparedStatement pst = con.prepareStatement(SELECT_USER_BY_EMAIL);
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			
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
		}
		
		return resultat;
	}
	
	public Utilisateurs getUserById(int id) throws DALException{
		Utilisateurs resultat = null;
		
		try(Connection con = ConnectionProvider.connection()){ 
			PreparedStatement pst = con.prepareStatement(SELECT_USER_BY_ID);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
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
		}
		return resultat;
	}
	
	public void insertUser(Utilisateurs user) throws DALException{
		try(Connection con = ConnectionProvider.connection()){
			PreparedStatement pStmt = con.prepareStatement(INSERT_USER);

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
			
		} catch(SQLException e) {
		throw new DALException("Impossible d'insérer l'utilisateur", e);
		}
	}
	
	public void updateUser(Utilisateurs user) throws DALException {
	    try (Connection con = ConnectionProvider.connection()) {
	        PreparedStatement pStmt = con.prepareStatement(UPDATE_USER);

	        pStmt.setString(1, user.getPseudo());
	        pStmt.setString(2, user.getLastName());
	        pStmt.setString(3, user.getFirstName());
	        pStmt.setString(4, user.getEmail());
	        pStmt.setString(5, user.getPhoneNumber());
	        pStmt.setString(6, user.getStreet());
	        pStmt.setString(7, user.getZipCode());
	        pStmt.setString(8, user.getCity());
	        pStmt.setString(9, user.getPassword());
	        pStmt.setInt(10, user.getId());

	        pStmt.executeUpdate();

	    } catch (SQLException e) {
	        throw new DALException("Impossible de mettre à jour l'utilisateur", e);
	    }
	}
}
