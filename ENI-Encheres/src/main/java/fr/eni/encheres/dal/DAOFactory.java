package fr.eni.encheres.dal;

import fr.eni.encheres.dal.interfaces.UtilisateursDAO;
import fr.eni.encheres.dal.jdbc.*;

public class DAOFactory {
	//Déclaration des attibuts d'interfaces 
	private static UtilisateursDAO utilisateurDAO;
	//private static EncheresDAO encheresDAO;
	//private static RetraitDAO retraitDAO
	//private static ArticlesVendusDAO aerticlesDAO
	
	//On s'assure que utilisateursDAO n'est pas un objet null envoyé à la base de données 
	public static UtilisateursDAO getUtilisateurDAO() {
		if(utilisateurDAO == null) {
			utilisateurDAO = new UtilisateurDAOJdbcImpl();
		}
		return utilisateurDAO;
	}
	
	//doit faire la m^me chose après pour les autres classes 
}
