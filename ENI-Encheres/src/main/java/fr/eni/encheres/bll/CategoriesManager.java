package fr.eni.encheres.bll;

import java.util.List;

import fr.eni.encheres.bo.Categories;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.interfaces.CategoriesDAO;
import fr.eni.encheres.exceptions.DALException;

public class CategoriesManager {
	public static CategoriesManager categoriesManager;
	private CategoriesDAO categoriesDAO;
	
	public CategoriesManager() {
		categoriesDAO = new DAOFactory().getCategoriesDAO();
	}
	
	public static CategoriesManager getInstance() throws InstantiationException, IllegalAccessException, ClassNotFoundException, Exception{
		if(categoriesManager == null) {
			categoriesManager = new CategoriesManager();
		}
		return categoriesManager;
	}
	
	public List<Categories> SelectALL() throws DALException{
		return categoriesDAO.SelectALL();
	}
	
	public Categories SelectById(int id) throws DALException{
		return categoriesDAO.SelectById(id);
	}

}
