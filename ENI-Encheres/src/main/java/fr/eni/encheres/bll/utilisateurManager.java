 package fr.eni.encheres.bll;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.eni.encheres.bo.Utilisateurs;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.interfaces.UtilisateursDAO;
import fr.eni.encheres.exceptions.BllException;
import fr.eni.encheres.exceptions.DALException;

/*import fr.eni.encheres.bo.articlesVendu;*/

/* ----- A faire -----*/
/*
 * - selection de tous les users
 * - récupération de tous les pseudo
 * - selection de l'utilisateur par son id(selectByid)
 * - selection par pseudo
 * -pour la connexion : userExit()
 * -gestion des session a voir
 * */

/* ----------------------*/



public class utilisateurManager {
	private UtilisateursDAO utilisateurDAO; 
	public static utilisateurManager utilisateurManager;; 
	
	public utilisateurManager() {
		utilisateurDAO = new DAOFactory().getUtilisateurDAO(); // Initialisation du DAO des utilisateurs
	}
	//Permet d'obtenir l'instance de la classe qui existe sinon elle se crée
	public static utilisateurManager getInstance() throws InstantiationException, IllegalAccessException, ClassNotFoundException, Exception{
		
		if(utilisateurManager == null) {
			utilisateurManager = new utilisateurManager();
		}
		return utilisateurManager;
	}
	
	
	//Sélection de tous les users
	public List<Utilisateurs> getAllUsers() throws DALException{
		return utilisateurDAO.getAllUsers();
	}
	
	// public String register(Ustilisateurs utilisateur)
    public String register(Utilisateurs utilisateurs) throws DALException, BllException {
    	
    	/*utiliser juste sa*/
    	//utilisateurDAO.insertUser(utilisateurs);
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
    
    
    
    /*
     * ------login
     * 
     * public Utilisateurs login(String email, String password) throws DALException {
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
     * */
	
	
	/*public articlesVendu SelectByID(String id) {
		// articlesVendu = articleDAO.SelectByID(id)
		//regarde l'objet utilisateur 
		//System.out.println(at.toString());
	}*/
	
	
}
