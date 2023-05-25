package fr.eni.encheres.bll;

import fr.eni.encheres.bo.ArticlesVendu;
import fr.eni.encheres.bo.Retraits;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.interfaces.RetraitsDAO;
import fr.eni.encheres.exceptions.DALException;

public class RetraitsManager {
	private RetraitsDAO retraitsDAO;
	public static RetraitsManager retraitsManager;
	
	public RetraitsManager() {
		retraitsDAO = new DAOFactory().getRetraitsDAO();
	}
	
	public static RetraitsManager getInstance() throws InstantiationException, IllegalAccessException, ClassNotFoundException, Exception{
		if(retraitsManager == null) {
			retraitsManager = new RetraitsManager();
		}
		return retraitsManager;
	}

	public void ajouterRetraits(Retraits retrait) throws DALException {
		retraitsDAO.insertRetrait(retrait);
	}
	
	public Retraits SelectByIdArticle(int idArticle) throws DALException{
		return retraitsDAO.SelectByIdArticle(idArticle);
	}
}