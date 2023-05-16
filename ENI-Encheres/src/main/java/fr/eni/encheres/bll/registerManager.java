package fr.eni.encheres.bll;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.eni.encheres.bo.Utilisateurs;
import fr.eni.encheres.dal.jdbc.UtilisateurDAOJdbcImpl;
import fr.eni.encheres.exceptions.DALException;

public class registerManager {
	private UtilisateurDAOJdbcImpl UtilisateurDAOJdbcImpl;

    public registerManager() {
        UtilisateurDAOJdbcImpl = new UtilisateurDAOJdbcImpl(); // Initialisez le DAO des utilisateurs
    }
    
    public String register(String pseudo, String firstName, String lastName, String email, String phoneNumber, String street, String zipCode, String city, String password) throws DALException {
    	List<String> emails = UtilisateurDAOJdbcImpl.getEmails();
    	List<String> pseudos = UtilisateurDAOJdbcImpl.getPseudos();
    	if (emails.contains(email)) {
    		return "Un compte est déjà associé à cette adresse mail."; 
    	}
    	if (pseudos.contains(pseudo)) {
    		return "Un compte est déjà associé à ce pseudo."; 
    	}
    	if (isValid(password)) {
    		Utilisateurs user = new Utilisateurs(pseudo, firstName, lastName, email, phoneNumber, street, zipCode, city, password);
    		UtilisateurDAOJdbcImpl.insertUser(user);
    		return "Le compte a été créé avec succès.";
    	} else {
    		return "Le mot de passe ne correspond pas aux critères de stratégie de mot de passe. (Au minimum : une majucule, une minuscule, un chiffre, un caractère spécial)";
    	}
    }
    
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";

    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

    public static boolean isValid(final String password) {
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
