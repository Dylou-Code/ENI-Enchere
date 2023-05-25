package fr.eni.encheres.bll;

import java.util.List;

import fr.eni.encheres.bo.ArticlesVendu;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.interfaces.ArticlesVenduDAO;
import fr.eni.encheres.exceptions.DALException;


public class ArticlesVenduManager {
	private ArticlesVenduDAO articleVenduDAO; 
	public static ArticlesVenduManager articlesVenduManager; 

	public ArticlesVenduManager() {
		articleVenduDAO = new DAOFactory().getArticlesDAO(); // Initialisation du DAO 
	}

	public static ArticlesVenduManager getInstance() throws InstantiationException, IllegalAccessException, ClassNotFoundException, Exception{
		if(articlesVenduManager == null) {
			articlesVenduManager = new ArticlesVenduManager();
		}
		return articlesVenduManager;
	}

	//Fonction qui récupère la liste complete de tous les articles 
	public List<ArticlesVendu> SelectAll() throws DALException{
		return articleVenduDAO.SelectAll();
	}

	//Fonction qui récupère la liste complete de tous les articles pour un utilisateur 
	public List<ArticlesVendu> SelectByIdUser(int idUser) throws DALException{
		return articleVenduDAO.SelectByIdUser(idUser);
	}
	
	public ArticlesVendu SelectByIdArticle(int idArticle) throws DALException{
		return articleVenduDAO.SelectById(idArticle);
	}

	public void ajouterArticle(ArticlesVendu article) throws DALException {
		articleVenduDAO.insertArticle(article);
	}

	public int selectLastInsertId() throws DALException {
		return articleVenduDAO.selectLastInsertId();
	}
}
