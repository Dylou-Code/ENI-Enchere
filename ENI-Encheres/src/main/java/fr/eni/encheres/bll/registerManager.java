package fr.eni.encheres.bll;

import java.util.List;
import fr.eni.encheres.exceptions.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.eni.encheres.bo.Utilisateurs;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.interfaces.UtilisateursDAO;
import fr.eni.encheres.dal.jdbc.UtilisateurDAOJdbcImpl;

public class registerManager {
	
	private UtilisateursDAO utilisateurDAO; 
	public static registerManager registerManager; 
	
	//contructeur par défaut
    public registerManager() {
    	utilisateurDAO = new DAOFactory().GetUtilisateurDAO(); // Initialisation  du  DAO des utilisateurs
    }
    
    
    //on instancie un constructeur qui sera charger de faire le lien entre la serblet et la couche bll  tout 
    //en s'assurant qu'on ne fais pas passer d'objet null ou qui'il n'y pas un une instace déjà en cours 
    public static registerManager getInstance() throws InstantiationException, IllegalAccessException, ClassNotFoundException, Exception{
		if(registerManager == null) {
			registerManager = new registerManager();
		}
		return registerManager;
	}
    
    // public String register(Ustilisateurs utilisateur)0
    public String register(String pseudo, String firstName, String lastName, String email, String phoneNumber, String street, String zipCode, String city, String password) throws DALException, BllException {
    	
    	
    	//initilialiser l'exception Bllexceptiuon (à utiliser dans chaque fonction)
    	BllException bllException = new BllException();
    	
    	List<String> emails = utilisateurDAO.getEmails();
    	List<String> pseudos = utilisateurDAO.getPseudos();
    	
    	//etape de vei
    	if (emails.contains(email)) {
    		//Ajoute ton message d'erreur à ta liste d'exception 
    		bllException.addErreur("Un compte est déjà associé a cet adresse mail");
    		//tu fais remonter ton erreurs dans ta servlets soit la couche au dessus de la BLL
    		throw bllException ;
    	}
    	if (pseudos.contains(pseudo)) {
    		bllException.addErreur("Un compte est déjà associé à ce pseudo.");
    		throw bllException ;
    	}
    	if (isValid(password)) {
    		Utilisateurs user = new Utilisateurs(pseudo, firstName, lastName, email, phoneNumber, street, zipCode, city, password);
    		utilisateurDAO.insertUser(user);
    		return "Le compte a été créé avec succès.";
    	} else {
    		bllException.addErreur("Le mot de passe ne correspond pas aux critères de stratégie de mot de passe. (Au minimum : une majucule, une minuscule, un chiffre, un caractère spécial)");
    		throw bllException ;
    	}
    }
    
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";

    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

    public static boolean isValid(final String password) {
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
