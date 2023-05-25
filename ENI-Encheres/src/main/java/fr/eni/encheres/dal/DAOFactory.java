package fr.eni.encheres.dal;


import fr.eni.encheres.dal.interfaces.ArticlesVenduDAO;
import fr.eni.encheres.dal.interfaces.CategoriesDAO;
import fr.eni.encheres.dal.interfaces.EncheresDAO;
import fr.eni.encheres.dal.interfaces.RetraitsDAO;
import fr.eni.encheres.dal.interfaces.UtilisateursDAO;
import fr.eni.encheres.dal.jdbc.ArticlesVenduDAOJdbcImpl;
import fr.eni.encheres.dal.jdbc.CategoriesDAOJdbcImpl;
import fr.eni.encheres.dal.jdbc.EncheresDAOJdbcImpl;
import fr.eni.encheres.dal.jdbc.RetraitsDAOJdbcImpl;
import fr.eni.encheres.dal.jdbc.UtilisateurDAOJdbcImpl;

//
public class DAOFactory {
	//Déclaration des attibuts d'interfaces 
	private static UtilisateursDAO utilisateurDAO;
	private static ArticlesVenduDAO articlesDAO;
	private static EncheresDAO encheresDAO;
	private static RetraitsDAO retraitsDAO;
	private static CategoriesDAO categorieDAO;
	
	
	//On s'assure que utilisateursDAO n'est pas un objet null envoyé à la base de données 
	public static UtilisateursDAO getUtilisateurDAO() {
		if(utilisateurDAO == null) {
			utilisateurDAO = new UtilisateurDAOJdbcImpl();
		}
		return utilisateurDAO;
	}
	
	public static CategoriesDAO getCategoriesDAO() {
		if (categorieDAO == null) {
			categorieDAO = new CategoriesDAOJdbcImpl();
		}
		return categorieDAO;
	}
	
	public static ArticlesVenduDAO getArticlesDAO() {
		if (articlesDAO == null) {
			articlesDAO = new ArticlesVenduDAOJdbcImpl();
		}
		return articlesDAO;
		
	}
	
	public static EncheresDAO getEncheresDAO() {
		if (encheresDAO == null) {
			encheresDAO = new EncheresDAOJdbcImpl();
		}
		return encheresDAO;
	}
	
	public static RetraitsDAO getRetraitsDAO() {
		if (retraitsDAO == null) {
			retraitsDAO = new RetraitsDAOJdbcImpl();
		}
		return retraitsDAO;
	}
	
}
