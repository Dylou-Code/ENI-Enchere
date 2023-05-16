package fr.eni.encheres.bll;

import fr.eni.encheres.bo.Utilisateurs;
import fr.eni.encheres.dal.jdbc.UtilisateurDAOJdbcImpl;

public class loginManager {
	private UtilisateurDAOJdbcImpl UtilisateurDAOJdbcImpl;

    public loginManager() {
        UtilisateurDAOJdbcImpl = new UtilisateurDAOJdbcImpl(); // Initialisez le DAO des utilisateurs
    }

    public Utilisateurs login(String email, String password) {
        Utilisateurs user =  UtilisateurDAOJdbcImpl.getEmails();
        if (user != null && user.getPassword().equals(password)) {
            return user; // Authentification réussie
        }
        return null; // Authentification échouée
    }
}
