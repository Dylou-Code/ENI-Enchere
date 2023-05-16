package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.bo.Utilisateurs;
import fr.eni.encheres.exceptions.DALException;

public interface UtilisateurDAO {
	
	public final String SELECT_ALL = "SELECT * FROM UTILISATEURS";
	public final String SELECT_PSEUDOS = "SELECT pseudo FROM UTILISATEURS";
	public final String SELECT_EMAILS = "SELECT email FROM UTILISATEURS";
	public final String SELECT_USER_BY_PSEUDO = "SELECT * FROM UTILISATEURS WHERE pseudo=?";
	public final String SELECT_USER_BY_EMAIL = "SELECT * FROM UTILISATEURS WHERE email=?";
	public final String SELECT_USER_BY_ID = "SELECT * FROM UTILISATEURS WHERE no_utilisateur=?";
	public final String INSERT_USER = "INSERT INTO UTILISATEURS(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe) VALUES (?,?,?,?,?,?,?,?,?)";

	public List<Utilisateurs> getAllUsers() throws DALException;
	public List<String> getPseudos() throws DALException;
	public List<String> getEmails() throws DALException;
	public Utilisateurs getUserByPseudo(String pseudo) throws DALException;
	public Utilisateurs getUserByEmail(String email) throws DALException;
	public Utilisateurs getUserById(int id) throws DALException;
	public void insertUser(Utilisateurs user) throws DALException;

}