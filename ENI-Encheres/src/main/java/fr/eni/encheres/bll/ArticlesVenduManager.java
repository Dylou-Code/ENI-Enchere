package fr.eni.encheres.bll;

import java.util.List;

import fr.eni.encheres.bo.ArticlesVendu;
import fr.eni.encheres.dal.interfaces.ArticlesVenduDAO;
import fr.eni.encheres.exceptions.DALException;


public class ArticlesVenduManager {
	private ArticlesVenduDAO articleVenduDAO; 
	public static ArticlesVenduManager articlesVenduManager; 
	
	public static ArticlesVenduManager getInstance() throws InstantiationException, IllegalAccessException, ClassNotFoundException, Exception{
		if(articlesVenduManager == null) {
			articlesVenduManager = new ArticlesVenduManager();
		}
		return articlesVenduManager;
	}
	
	public static ArticlesVenduManager getInstance() throws InstantiationException, IllegalAccessException, ClassNotFo	//Fonction qui récupère la liste complete de tout les articles confondu
	articlesVenduManager rticles 
	public List<ArticlesVendu> SelectAll() throws DALException{
=======
	//Fonction qui récupère la liste complete de tout les articles confondu
	public List<ArticlesVendu> SelectALL() throws DALException{
		return articleVenduDAO.SelectAll();
	}
}
