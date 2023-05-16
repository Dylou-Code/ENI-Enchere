package fr.eni.encheres.bll;

import java.util.List;

import fr.eni.encheres.bo.Utilisateurs;
import fr.eni.encheres.dal.jdbc.UtilisateurDAOJdbcImpl;
import fr.eni.encheres.exceptions.DALException;

public class loginManager {
	private UtilisateurDAOJdbcImpl UtilisateurDAOJdbcImpl;

    public loginManager() {
        UtilisateurDAOJdbcImpl = new UtilisateurDAOJdbcImpl(); // Initialisez le DAO des utilisateurs
    }

    public Utilisateurs login(String email, String password) throws DALException {
    	List<String> emails = UtilisateurDAOJdbcImpl.getEmails();
    	List<String> pseudos = UtilisateurDAOJdbcImpl.getPseudos();
    	List<Utilisateurs> users = UtilisateurDAOJdbcImpl.getAllUsers();
        Utilisateurs result =  null;
        if (emails.contains(email)) {
        	for (String e : emails) {
        		for (Utilisateurs user : users) {
        			if (e.equals(user.getEmail()) && password.equals(user.getPassword())) {
        				result = user;
        			}
        		}
        	}
        }
        return result;
    }
}
