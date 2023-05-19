package fr.eni.encheres.dal;

import fr.eni.encheres.dal.interfaces.ArticlesVenduDAO;
import fr.eni.encheres.dal.interfaces.EncheresDAO;
import fr.eni.encheres.dal.interfaces.UtilisateursDAO;
import fr.eni.encheres.dal.jdbc.ArticlesVenduDAOJdbcImpl;
import fr.eni.encheres.dal.jdbc.EncheresDAOJdbcImpl;
import fr.eni.encheres.dal.jdbc.UtilisateurDAOJdbcImpl;

public class DAOFactory {
	//Déclaration des attibuts d'interfaces 
	private static UtilisateursDAO utilisateurDAO;
	private static ArticlesVenduDAO articlesDAO;
	private static EncheresDAO encheresDAO;
	//private static RetraitDAO retraitDAO
	
	//On s'assure que utilisateursDAO n'est pas un objet null envoyé à la base de données 
	public static UtilisateursDAO getUtilisateurDAO() {
		if(utilisateurDAO == null) {
			utilisateurDAO = new UtilisateurDAOJdbcImpl();
		}
		return utilisateurDAO;
	}
	
	public static ArticlesVenduDAO getArticlesDAO() {
		if (articlesDAO == null) {
			articlesDAO = new ArticlesVenduDAOJdbcImpl();
		}
		return articlesDAO;
		
	}
	
	public static EncheresDAO encheresDAO() {
		if (encheresDAO == null) {
			encheresDAO = new EncheresDAOJdbcImpl();
		}
		return encheresDAO;
	}
	
	//doit faire la m^me chose après pour les autres classes 
}
