package fr.eni.encheres.dal.interfaces;

import java.util.List;

import fr.eni.encheres.bo.Categories;
import fr.eni.encheres.exceptions.DALException;

public abstract interface CategoriesDAO {
	
	public abstract void Insert (Categories categorie) throws DALException;
	public abstract void Update (Categories categorie) throws DALException;
	public abstract List<Categories> SelectALL() throws DALException;
	public abstract Categories SelectById(int no_categorie) throws DALException;
	public abstract void Delete(int no_categorie) throws DALException;
}
