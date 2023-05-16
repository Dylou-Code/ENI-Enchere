 package fr.eni.encheres.bll;

import java.util.List;

import fr.eni.encheres.dal.jdbc.UtilisateurDAOJdbcImpl;

private UtilisateurDAOJdbcImpl UtilisateurDAOJdbcImpl;


public class utilisateurManager {
	private UtilisateurDAOJdbcImpl UtilisateurDAOJdbcImpl;
	public utilisateurManager() {
	    UtilisateurDAOJdbcImpl = new UtilisateurDAOJdbcImpl();
	}

	
	public List<ListeCourses> fetchListeCourses() {
		return listeCourseDAO.findAll();
	}
}
