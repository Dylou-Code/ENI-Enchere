package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.bo.Utilisateurs;

public abstract interface UtilisateurDAO {
	
	public final String SELECT_ALL = "Select * FROM Utilisateurs";
	public final String SELECT_PSEUDOS = "Select pseudo FROM Utilisateurs";
	public final String SELECT_EMAILS = "Select email FROM Utilisateurs";
	public final String SELECT_USER_BY_PSEUDO = "Select * FROM Utilisateurs WHERE pseudo=?";
	public final String SELECT_USER_BY_EMAIL = "Select * FROM Utilisateurs WHERE email=?";

	public List<Utilisateurs> getAllUsers() throws DALException;
	public List<String> getPseudos() throws DALException;
	public List<String> getEmails() throws DALException;
	public Utilisateurs getUserByPseudo(String pseudo) throws DALException;
	public Utilisateurs getUserByEmail(String email) throws DALException;

}
