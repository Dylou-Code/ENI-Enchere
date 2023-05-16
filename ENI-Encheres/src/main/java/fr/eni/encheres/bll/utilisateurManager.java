 package fr.eni.encheres.bll;

import java.util.List;

import fr.eni.encheres.dal.jdbc.UtilisateurDAOJdbcImpl;



public class utilisateurManager {
	private UtilisateurDAOJdbcImpl UtilisateurDAOJdbcImpl;
	public utilisateurManager() {
	    UtilisateurDAOJdbcImpl = new UtilisateurDAOJdbcImpl();
	}
}
